package com.pl.flightsmaven.security;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
	private final JwtService jwtService;
	private final AuthenticationManager authManager;
	
	@PostMapping("/login")
	public String token(@Valid @RequestBody LoginDTO loginRequest) {
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
		LOG.debug("Token requested for user: '{}'", authentication.getName());
		String token = jwtService.generateToken(authentication);
		LOG.debug("Token granted: {}", token);
		return token;
	}
}
