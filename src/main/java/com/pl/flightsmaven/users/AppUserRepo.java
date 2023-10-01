package com.pl.flightsmaven.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
	boolean existsByEmail(String email);
}

