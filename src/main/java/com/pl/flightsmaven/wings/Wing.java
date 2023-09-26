package com.pl.flightsmaven.wings;

import com.pl.flightsmaven.flights.Flight;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class Wing {

   String name;
   Category category;
   float initialHours;
   float totalHours;
   @OneToMany
   List<Flight> flights;
}
