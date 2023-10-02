package com.pl.flightsmaven.security;

import com.pl.flightsmaven.users.AppUserService;
import com.pl.flightsmaven.users.RegisterDTO;
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
	final AppUserService appUserService;
	@PostMapping("/login")
	ResponseEntity<?> login(@RequestBody(required = false) @Valid LoginDTO loginRequest) {
		if(loginRequest == null) return ResponseEntity.status(400).body("loginRequest body is null");
		return ResponseEntity.status(200).body(authService.login(loginRequest));
		
	}
	@PostMapping("/register")
	ResponseEntity<?> register(@RequestBody(required = false) @Valid RegisterDTO registerRequest) {
		if(registerRequest == null) return ResponseEntity.status(400).body("registerRequest body is null");
		return ResponseEntity.status(200).body(appUserService.register(registerRequest));
	}
}
