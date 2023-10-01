package com.pl.flightsmaven.users;

import com.pl.flightsmaven.users.AppUser;
import com.pl.flightsmaven.users.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

import static com.pl.flightsmaven.users.Role.ROLE_USER;

public record RegisterDTO(
		  @NotBlank(message = "email is mandatory")
		  String name,
		  @NotBlank(message = "email is mandatory")
		  @Email(message = "Invalid email")
		  String email,
		  @NotBlank(message = "password is mandatory")
		  String password
) {
	AppUser toAppUser() {
		Set<Role> roles = Set.of(ROLE_USER);
		return new AppUser(null, name, email, password, roles);
	}
}
