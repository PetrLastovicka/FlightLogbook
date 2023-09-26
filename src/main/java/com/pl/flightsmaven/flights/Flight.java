package com.pl.flightsmaven.flights;

import com.pl.flightsmaven.wings.Wing;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
@Entity
public class Flight {
   @ManyToOne
   Wing wing;
}
