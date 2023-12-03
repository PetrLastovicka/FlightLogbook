package com.pl.flightlogger.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
	final JwtService jwtService;
	final AuthenticationManager authManager;
	final PasswordEncoder passwordEncoder;
	
	String login(LoginDTO loginRequest) {
		try {
			Authentication authentication = authManager
					  .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
			return jwtService.generateToken(authentication);
		} catch (AuthenticationException e) {
			throw new UsernameNotFoundException("Invalid credentials");
		}
	}
	
}
