package com.pl.flightsmaven.wings;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pl.flightsmaven.flights.Flight;
import jakarta.persistence.*;
import lombok.*;
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
	String size;
	@Enumerated(EnumType.STRING)
	Category category;
	boolean my;
	LocalDate purchased;
	float initialHours;
	LocalDate nextCheckDate;
	float nextCheckHours;
	float totalHours;
	boolean active;
	//@JsonIgnore
	@OneToMany(mappedBy = "wing", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Flight> flights;
}
