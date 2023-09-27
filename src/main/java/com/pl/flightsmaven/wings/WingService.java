package com.pl.flightsmaven.wings;

import java.util.List;

public interface WingService {
   Wing create(NewWingDTO request);
   List<Wing> getAll();
}
