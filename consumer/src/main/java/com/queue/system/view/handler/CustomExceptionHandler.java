package com.queue.system.view.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.queue.system.core.exception.IntegrationException;
import com.queue.system.core.exception.TooManyRequestsException;
import com.queue.system.view.dto.response.ErrorResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(TooManyRequestsException.class)
	public ResponseEntity<ErrorResponseDTO> handlerTooManyRequests(TooManyRequestsException exception, HttpServletRequest request){
		var response = new ErrorResponseDTO("Too many requests, user added to the queue.");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
	
	@ExceptionHandler(IntegrationException.class)
	public ResponseEntity<ErrorResponseDTO> handlerIntegrationErrors(IntegrationException exception, HttpServletRequest request){
		var response = new ErrorResponseDTO("Error when calling provider");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
