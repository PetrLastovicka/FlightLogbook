package com.pl.flightsmaven.security;

import com.pl.flightsmaven.users.AppUser;
import com.pl.flightsmaven.users.RegisterDTO;
import jakarta.validation.Valid;
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
	String login(@Valid LoginDTO loginRequest) {
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
		return jwtService.generateToken(authentication);
	}
	
	AppUser register(@Valid RegisterDTO registerRequest) {
		return null;
	}
}
