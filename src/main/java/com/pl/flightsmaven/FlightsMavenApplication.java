package com.pl.flightsmaven;

import com.pl.flightsmaven.security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class FlightsMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsMavenApplication.class, args);
	}

}
