package com.pl.flightlogger;

import com.pl.flightlogger.flights.Flight;
import com.pl.flightlogger.flights.FlightRepo;
import com.pl.flightlogger.security.RsaKeyProperties;
import com.pl.flightlogger.users.AppUser;
import com.pl.flightlogger.users.AppUserRepo;
import com.pl.flightlogger.users.Role;
import com.pl.flightlogger.wings.Category;
import com.pl.flightlogger.wings.Wing;
import com.pl.flightlogger.wings.WingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Set;

@EnableConfigurationProperties(RsaKeyProperties.class)
@RequiredArgsConstructor
@SpringBootApplication
public class FLightLogbook implements CommandLineRunner {
	private final AppUserRepo userRepo;
	private final FlightRepo flightRepo;
	private final WingRepo wingRepo;
	private final PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(FLightLogbook.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Set<Role> user = Set.of(Role.ROLE_USER);
		Set<Role> admin = Set.of(Role.ROLE_USER, Role.ROLE_ADMIN);
		userRepo.save(AppUser.builder()
				  .name("admin")
				  .email("admin@email.com")
				  .password(passwordEncoder.encode("Password"))
				  .roles(admin)
				  .build());
		userRepo.save(AppUser.builder()
				  .name("user1")
				  .email("user1@email.com")
				  .password(passwordEncoder.encode("Password"))
				  .roles(user)
				  .build());
		Wing wing1 = wingRepo.save(Wing.builder()
				  .manufacturer("UP")
				  .model("Rimo")
				  .category(Category.ENA)
				  .active(true).size("S/M")
				  .build());
		Wing wing2 = wingRepo.save(Wing.builder()
				  .manufacturer("UP")
				  .model("Kibo2")
				  .category(Category.ENB)
				  .active(true)
				  .size("S/M")
				  .build());
		
		
		Flight flight1 = Flight.builder()
				  .date(LocalDate.now())
				  .duration(1.5f)
				  .location("Basssano")
				  .build();
		Flight flight2 = Flight.builder()
				  .date(LocalDate.now())
				  .duration(2.5f)
				  .location("Koessen")
				  .build();
		
		flightRepo.save(flight1);
		flightRepo.save(flight2);
		
		//flight1 = flightRepo.findById(1L).orElseThrow();
		
		flight1.setWing(wing1);
		flightRepo.save(flight1);
		flight2.setWing(wing2);
		flightRepo.save(flight2);
	}
}
