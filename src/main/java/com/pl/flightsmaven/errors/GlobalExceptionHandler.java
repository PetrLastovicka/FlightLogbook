package com.pl.flightsmaven.errors;

import jakarta.persistence.EntityExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;


@RestControllerAdvice
class GlobalExceptionHandler {
	//for use with @Valid annotation
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e) {
		List<String> errors = e.getBindingResult()
				  .getFieldErrors()
				  .stream()
				  .map(x -> x.getDefaultMessage())
				  .toList();
		return ResponseEntity.status(406).body(errors);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	ResponseEntity<?> handleEntityExistsExceptionException(EntityExistsException e) {
		return ResponseEntity.status(409).body(e.getMessage());
	}
	
	@ExceptionHandler(DatabaseException.class)
	ResponseEntity<?> handleDatabaseException(DatabaseException e) {
		return ResponseEntity.status(500).body(e.getMessage());
	}
}
