package com.pl.flightlogger;

import com.pl.flightlogger.security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class FLightLogger {

	public static void main(String[] args) {
		SpringApplication.run(FLightLogger.class, args);
	}

}
