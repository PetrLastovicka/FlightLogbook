package com.pl.flightsmaven.flights;

import com.pl.flightsmaven.wings.Wing;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "flights")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "wing_id")
	Wing wing;
	String location;
	LocalDate date;
	LocalTime startTime;
	float duration;
	int maxAltitude;
	int minAltitude;
	float maxSink;
	float maxClimb;
	float odometer;
}
