package com.pl.flightsmaven.users;

import com.pl.flightsmaven.errors.DatabaseException;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AppUserService {
	private final AppUserRepo appUserRepo;
	private final PasswordEncoder passwordEncoder;
	
	public AppUser register(RegisterDTO registerRequest) {
		if (appUserRepo.existsByEmail(registerRequest.email())) {
			throw new EntityExistsException(String.format("Email %s is already registered", registerRequest.email()));
		}
		try {
			AppUser appUser = AppUser.builder()
					  .name(registerRequest.name())
					  .email(registerRequest.email())
					  .password(passwordEncoder.encode(registerRequest.password()))
					//  .password(registerRequest.password())
					  .roles(Set.of(Role.ROLE_USER))
					  .build();
			return appUserRepo.save(appUser);
		} catch (Exception e) {
			throw new DatabaseException("Saving to database failed");
		}
	}
}
