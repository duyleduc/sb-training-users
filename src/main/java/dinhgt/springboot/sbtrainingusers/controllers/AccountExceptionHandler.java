package dinhgt.springboot.sbtrainingusers.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dinhgt.springboot.sbtrainingusers.errors.ErrorResponse;

@RestControllerAdvice
public class AccountExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerException(AccountRestException error){
		ErrorResponse errorResponse = new ErrorResponse();
	
		errorResponse.setHttp_code(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(error.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleUpdateException(AccountUpdateException error){
		ErrorResponse errorResponse = new ErrorResponse();
	
		errorResponse.setHttp_code(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(error.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
}
