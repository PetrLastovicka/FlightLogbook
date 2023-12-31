package com.pl.flightlogger.errors;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
	@ExceptionHandler(HttpMessageNotReadableException.class)
	ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return ResponseEntity.status(400).body(e.getMessage());
	}
	@ExceptionHandler(EntityExistsException.class)
	ResponseEntity<?> handleEntityExistsException(EntityExistsException e) {
		return ResponseEntity.status(409).body(e.getMessage());
	}
	@ExceptionHandler(EntityNotFoundException.class)
	ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException e) {
		return ResponseEntity.status(404).body(e.getMessage());
	}
	
	@ExceptionHandler(DatabaseException.class)
	ResponseEntity<?> handleDatabaseException(DatabaseException e) {
		return ResponseEntity.status(500).body(e.getMessage());
	}
	@ExceptionHandler(UsernameNotFoundException.class)
	ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException e) {
		return ResponseEntity.status(404).body(e.getMessage());
	}
}
