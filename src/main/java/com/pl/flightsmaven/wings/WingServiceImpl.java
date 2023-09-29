package com.pl.flightsmaven.wings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WingServiceImpl implements WingService {
	final WingRepo wingRepo;
	
	
	
	@Override
	public Wing create(@Validated NewWingDTO request) {
		if (request.my) {
			Wing wing = Wing
					  .builder()
					  .manufacturer(request.manufacturer)
					  .model(request.model)
					  .size(request.size)
					  .category(request.category)
					  .my(request.my)
					  .purchased(request.purchased)
					  .initialHours(request.initialHours)
					  .nextCheckDate(request.nextCheckDate)
					  .nextCheckHours(request.nextCheckHours)
					  .active(true)
					  .build();
			return wingRepo.save(wing);
		}
		Wing wing = Wing
				  .builder()
				  .manufacturer(request.manufacturer)
				  .model(request.model)
				  .size(request.size)
				  .category(request.category)
				  .my(request.my)
				  .active(true)
				  .build();
		return wingRepo.save(wing);
	}
	
	@Override
	public List<Wing> getAll() {
		return wingRepo.findAll();
	}
}
