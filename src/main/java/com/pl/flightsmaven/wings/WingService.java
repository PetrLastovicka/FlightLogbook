package com.pl.flightsmaven.wings;

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
			return wingRepo.save(request.toWing());
	}
	
	public List<Wing> getAll() {
		return wingRepo.findAll();
	}
}
