package com.pl.flightsmaven.flights;

import com.pl.flightsmaven.wings.WingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
	final FlightRepo flightRepo;
	final WingRepo wingRepo;
	
	Flight create(NewFlightDTO request){
		Flight flight = Flight.builder()
				  .wing(wingRepo.findById(request.wingId).get())
				  .location(request.location)
				  .date(request.date)
				  .duration(request.duration)
				  .build();
		return flightRepo.save(flight);
	}
	List<Flight> getAll(){
		return flightRepo.findAll();
	}
	
	
}