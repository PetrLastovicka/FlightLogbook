package com.pl.flightlogger.wings;



import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

// TODO: 01.10.2023 fix validation for category and my
record NewWingDTO (
   
   @NotBlank
   String manufacturer,
   @NotBlank
   String model,
   @NotBlank
   String size,
  // @NotBlank
   @Enumerated(EnumType.STRING)
   Category category,
  // @NotBlank
   boolean my,
   LocalDate purchased,
   float initialHours,
   LocalDate nextCheckDate,
   float nextCheckHours
){
   Wing toWing(){
      return new Wing(
              null,
             manufacturer,
              model,
              size,
              category,
              my,
              purchased,
              initialHours,
              nextCheckDate,
              nextCheckHours,
              initialHours,
               0,
              true,
              null);
   }
}
