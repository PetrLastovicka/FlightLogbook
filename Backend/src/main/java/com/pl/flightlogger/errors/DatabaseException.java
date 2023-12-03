package com.pl.flightlogger.errors;

public class DatabaseException extends RuntimeException {
	
	public DatabaseException(String message) {
		super(message);
	}
}