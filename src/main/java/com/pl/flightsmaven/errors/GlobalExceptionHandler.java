package com.pl.flightsmaven.errors;

import jakarta.persistence.EntityExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e) {
		// TODO: 01.10.2023 update to return all errors
		return ResponseEntity.status(406).body(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		
	}
	@ExceptionHandler(EntityExistsException.class)
	ResponseEntity<?> handleDataIntegrityViolationException(EntityExistsException e) {
		return ResponseEntity.status(409).body(e.getMessage());
	}
	
	@ExceptionHandler(DatabaseException.class)
	ResponseEntity<?> handleDatabaseException(DatabaseException e) {
		return ResponseEntity.status(500).body(e.getMessage());
	}
	
	
	
}
