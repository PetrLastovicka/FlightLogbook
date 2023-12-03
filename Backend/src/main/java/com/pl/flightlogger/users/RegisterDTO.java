package com.pl.flightlogger.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record RegisterDTO(
		  @NotBlank(message = "username is mandatory")
		  String name,
		  @NotBlank(message = "email is mandatory")
		  @Email(message = "Invalid email")
		  String email,
		  @NotBlank(message = "password is mandatory")
		  String password
) {
	/*AppUser toAppUser() {
		Set<Role> roles = Set.of(ROLE_USER);
		return new AppUser(null, name, email, password, roles);
	}*/
}
