package com.pl.flightsmaven.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
	final JwtService jwtService;
	final AuthenticationManager authManager;
	String login(LoginDTO loginRequest) {
		Authentication authentication = authManager
				  .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
		return jwtService.generateToken(authentication);
		
	}
	
}
