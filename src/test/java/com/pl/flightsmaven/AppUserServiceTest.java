package com.pl.flightsmaven;

import com.pl.flightsmaven.users.AppUser;
import com.pl.flightsmaven.users.AppUserService;
import com.pl.flightsmaven.users.RegisterDTO;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class AppUserServiceTest {
	@Autowired
	 AppUserService appUserService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	@DisplayName("Test with correct input")
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
	@Test
	@DisplayName("Test with existing email")
	void registerAppUserTestNokWithExistingEmail() {
		RegisterDTO registerRequest = RegisterDTO.builder()
				  .name("test")
				  .password(passwordEncoder.encode("Password"))
				  .email("test1@test.com")
				  .build();
		appUserService.register(registerRequest);
		
		EntityExistsException e = assertThrows(EntityExistsException.class, () -> {
			appUserService.register(registerRequest);
		});
		assertEquals("Email test1@test.com is already registered", e.getMessage());
	}
}
