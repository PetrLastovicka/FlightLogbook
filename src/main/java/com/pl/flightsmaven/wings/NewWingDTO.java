package com.pl.flightsmaven.wings;



import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewWingDTO {
   
   @NonNull
   String manufacturer;
   @NonNull
   String model;
   @NonNull
   String size;
   
   @Enumerated(EnumType.STRING)
   Category category;
   boolean my;
   LocalDate purchased;
   float initialHours;
   LocalDate nextCheckDate;
   float nextCheckHours;
}
