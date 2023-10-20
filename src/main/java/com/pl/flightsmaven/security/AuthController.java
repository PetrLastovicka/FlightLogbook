package com.pl.flightsmaven.security;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
class AuthController {
	final AuthService authService;
	
	@PostMapping("/login")
	ResponseEntity<?> login(@RequestBody(required = false) @Valid LoginDTO loginRequest) {
		if(loginRequest == null) return ResponseEntity.status(400).body("loginRequest body is null");
		return ResponseEntity.status(200).body(authService.login(loginRequest));
		
	}
	
}
