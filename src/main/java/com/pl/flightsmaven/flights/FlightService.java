package com.pl.flightsmaven.flights;

import com.pl.flightsmaven.errors.DatabaseException;
import com.pl.flightsmaven.wings.Wing;
import com.pl.flightsmaven.wings.WingRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
	final FlightRepo flightRepo;
	final WingRepo wingRepo;
	
	Flight create(NewFlightDTO request) {
		//TODO: handle null DTO
		
		Wing wing = null;
		try {
			wing = wingRepo.findById(request.wingId()).orElseThrow(() -> new EntityNotFoundException("Wing not found"));
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new DatabaseException("Loading flights from database failed");
		}
		wing.setTotalFlights(wing.getTotalFlights() + 1);
		wing.setTotalHours(wing.getTotalHours() + request.duration());
		try {
			wingRepo.save(wing);
		} catch (Exception e) {
			throw new DatabaseException("Saving wing to database failed");
		}
		
		try {
			Flight flight = Flight.builder()
					  .wing(wing)
					  .location(request.location())
					  .date(request.date())
					  .duration(request.duration())
					  .build();
			return flightRepo.save(flight);
		} catch (Exception e) {
			throw new DatabaseException("Saving flight to database failed");
		}
	}
	
	List<Flight> getAll() {
		try {
			return flightRepo.findAll();
		} catch (Exception e) {
			throw new DatabaseException("Loading flights from database failed");
		}
		
	}
	
}
