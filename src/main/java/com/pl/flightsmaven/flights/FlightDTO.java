package com.pl.flightsmaven.flights;

public class FlightDTO {
	Long id;
	Long wingId;
	
	public FlightDTO() {
		this.id = 1L;
		this.wingId = 1L;
	}
	
	public FlightDTO(Flight flight) {
		this.id = flight.getId();
		this.wingId = flight.getWing().getId();
	}
}
