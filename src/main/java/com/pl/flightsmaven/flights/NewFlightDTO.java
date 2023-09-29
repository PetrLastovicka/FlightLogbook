package com.pl.flightsmaven.flights;


import com.pl.flightsmaven.wings.Category;
import com.pl.flightsmaven.wings.Wing;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewFlightDTO {
   Long wingId;
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
