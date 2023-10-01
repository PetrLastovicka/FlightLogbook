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
	ResponseEntity<?> login(@RequestBody @Valid LoginDTO loginRequest) {
		return ResponseEntity.status(200).body(authService.login(loginRequest));
		
	}
	@PostMapping("/register")
	ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerRequest) {
		return ResponseEntity.status(200).body(appUserService.register(registerRequest));
	}
}
