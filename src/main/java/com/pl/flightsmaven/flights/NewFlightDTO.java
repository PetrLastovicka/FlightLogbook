package com.pl.flightsmaven.flights;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

// TODO: 01.10.2023  fix validation
record NewFlightDTO(
		 // @NotBlank(message = "Wing Id is mandatory")
		  Long wingId,
		  @NotBlank(message = "Location is mandatory")
		  String location,
		 // @NotBlank(message = "Date is mandatory")
		  LocalDate date,
		  LocalTime startTime,
		  //@NotBlank(message = "Flight duration is mandatory")
		  float duration,
		  int maxAltitude,
		  int minAltitude,
		  float maxSink,
		  float maxClimb,
		  float odometer
) {
}
