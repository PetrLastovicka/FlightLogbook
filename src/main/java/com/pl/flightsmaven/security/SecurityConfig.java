package com.pl.flightsmaven.security;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.pl.flightsmaven.users.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	final RsaKeyProperties jwtConfigProperties;
	final AppUserRepo userRepo;
	public UserDetailsService userDetailService() {
		return username -> userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}
	
	@Bean
	public AuthenticationManager authManager() {
		var authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(authProvider);
	}
	
	/*@Bean
	public UserDetailsService users() {
		return new InMemoryUserDetailsManager(
				  User.withUsername("user")
							 .password("{noop}Password")
							 .roles("USER")
							 .authorities("read")
							 .build()
		);
	}*/
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				  .csrf(AbstractHttpConfigurer::disable)
				  .authorizeHttpRequests(auth -> auth
							 .requestMatchers("/api/auth/**").permitAll()
							 .requestMatchers("/api/users/register").permitAll()
							 .anyRequest().permitAll()//.authenticated()
				  )
				  .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				  .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
				  .exceptionHandling((ex) -> ex
							 .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
							 .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
				  )
				  .build();
	}
	
	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(jwtConfigProperties.publicKey()).build();
	}
	
	@Bean
	JwtEncoder jwtEncoder() {
		JWK jwk = new RSAKey.Builder(jwtConfigProperties.publicKey()).privateKey(jwtConfigProperties.privateKey()).build();
		JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwks);
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
