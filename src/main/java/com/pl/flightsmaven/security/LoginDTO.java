package com.pl.flightsmaven.security;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
		  @NotBlank(message = "username is mandatory")
		  String username,
		  @NotBlank(message = "password is mandatory")
		  String password
) {
}
