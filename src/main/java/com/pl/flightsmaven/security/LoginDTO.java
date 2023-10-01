package com.pl.flightsmaven.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
		  @NotBlank(message = "email is mandatory")
		  @Email(message = "Invalid email")
		  String username,
		  @NotBlank(message = "password is mandatory")
		  String password
) {
}
