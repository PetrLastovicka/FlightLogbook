package com.pl.flightsmaven.wings;

import org.springframework.validation.annotation.Validated;

import java.util.List;

public interface WingService {
   Wing create(@Validated NewWingDTO request);
   List<Wing> getAll();
}
