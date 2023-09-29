package com.pl.flightsmaven.flights;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepo extends CrudRepository<Flight, Long> {
   List<Flight> findAll();
}
