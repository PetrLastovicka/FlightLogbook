package com.pl.flightsmaven;

import com.pl.flightsmaven.users.AppUser;
import com.pl.flightsmaven.users.AppUserRepo;
import com.pl.flightsmaven.users.AppUserService;
import com.pl.flightsmaven.users.RegisterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AppUserServiceTest {
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppUserRepo appUserRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	void registerAppUserTestOk() {
		RegisterDTO registerRequest = RegisterDTO.builder()
				  .name("test")
				  .password(passwordEncoder.encode("Password"))
				  .email("test@test.com")
				  .build();
		
		AppUser result = appUserService.register(registerRequest);
		
		
		assertEquals(registerRequest.name(), result.getName());
		assertEquals(registerRequest.email(), result.getEmail());
		assertTrue(passwordEncoder.matches(registerRequest.password(), result.getPassword()));
	}
}
