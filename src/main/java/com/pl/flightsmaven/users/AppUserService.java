package com.pl.flightsmaven.users;

import com.pl.flightsmaven.errors.DatabaseException;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {
	private final AppUserRepo appUserRepo;
	
	public AppUser register(RegisterDTO registerRequest) {
		if (appUserRepo.existsByEmail(registerRequest.email())) {
			throw new EntityExistsException(String.format("Email %s is already registered", registerRequest.email()));
		}
		try {
			return appUserRepo.save(registerRequest.toAppUser());
		} catch (Exception e) {
			throw new DatabaseException("Saving to database failed");
		}
	}
}
