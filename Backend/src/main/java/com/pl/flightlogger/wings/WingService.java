package com.pl.flightlogger.wings;

import com.pl.flightlogger.errors.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WingService {
	final WingRepo wingRepo;
	
	Wing create(@Valid NewWingDTO request) {
		//todo: check if wing with given manufacturer, model and size already exists
		//TODO: handle null DTO
		
		try {
			return wingRepo.save(request.toWing());
		} catch (Exception e) {
			throw new DatabaseException("Saving wing to database failed");
		}
	}
	
	List<Wing> getAll() {
		
		try {
			return wingRepo.findAll();
		} catch (Exception e) {
			throw new DatabaseException("Loading wings from database failed");
		}
	}
	
	Wing getById(Long id) {
		try {
			return wingRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Wing not found"));
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new DatabaseException("Loading wing from database failed");
		}
	}
}
