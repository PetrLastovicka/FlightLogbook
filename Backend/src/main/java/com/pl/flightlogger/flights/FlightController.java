package com.pl.flightlogger.flights;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flights")
public class FlightController {
	final FlightService flightService;
	@GetMapping
	ResponseEntity<?> getAll(){
		return ResponseEntity.status(200).body(flightService.getAll());
	}
	@PostMapping
	ResponseEntity<?> create(@RequestBody @Valid NewFlightDTO request) {
		return ResponseEntity.status(201).body(flightService.create(request));
	}
	
}
