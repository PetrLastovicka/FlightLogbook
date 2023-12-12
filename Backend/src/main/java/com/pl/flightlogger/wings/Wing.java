package com.pl.flightlogger.wings;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pl.flightlogger.flights.Flight;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "wings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public class Wing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String manufacturer;
	String model;
	String wingSize;
	@Enumerated(EnumType.STRING)
	Category category;
	boolean my;
	LocalDate purchased;
	float initialHours;
	float totalHours;
	int totalFlights;
	LocalDate nextCheckDate;
	float nextCheckHours;
	boolean active;
	//@JsonIgnore
	@OneToMany(mappedBy = "wing", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Flight> flights;
}
