package com.example.SpringSecurityJWT.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = AccessRoleException.class )
	public ResponseEntity<String> displayException() {
		
		return new ResponseEntity<String>("user not allowed to access", HttpStatus.FORBIDDEN);
		
	}
	
	@ExceptionHandler(value =InvalidUserException.class )
	public ResponseEntity<String> displayInvalidUserException() {
		
		return new ResponseEntity<String>("user cannot be validated", HttpStatus.UNAUTHORIZED);
		
	}
	
	@ExceptionHandler(value = TokenExpiredException.class)
	public ResponseEntity<String> TokenExpiredException() {
		
		return new ResponseEntity<String>("token has expired", HttpStatus.UNAUTHORIZED);
		
	}

}
