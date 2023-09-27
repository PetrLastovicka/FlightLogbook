package com.pl.flightsmaven.wings;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewWingDTO {
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
}
