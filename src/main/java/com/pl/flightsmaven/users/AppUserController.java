package com.pl.flightsmaven.users;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AppUserController {
	final AppUserService appUserService;
	
	@PostMapping("/register")
	ResponseEntity<?> register(@RequestBody(required = false) @Valid RegisterDTO registerRequest) {
		if(registerRequest == null) return ResponseEntity.status(400).body("registerRequest body is null");
		return ResponseEntity.status(200).body(appUserService.register(registerRequest));
	}
}
