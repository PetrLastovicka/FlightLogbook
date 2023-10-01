package com.pl.flightsmaven.users;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {
	private final AppUserRepo appUserRepo;
	public AppUser register(@Valid RegisterDTO registerRequest) {
		return appUserRepo.save(registerRequest.toAppUser());
	}
	
}
