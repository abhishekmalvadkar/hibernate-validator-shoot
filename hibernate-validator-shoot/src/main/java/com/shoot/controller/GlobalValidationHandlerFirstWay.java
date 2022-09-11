package com.shoot.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shoot.dto.ErrorResponseDTO;

/**
 * @author ABHISHEK MALVADKAR
 * Note : This is the first way to handle bean validation violation at single place
 * 		  use anyone of these two way , I have committed both way for reference only
 * @see {@link GlobalValidationHandlerSecondWay}*
 */
@ControllerAdvice
public class GlobalValidationHandlerFirstWay extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors = ex.getAllErrors();
		List<String> errorMessages = errors.stream()
			  .map(ObjectError::getDefaultMessage)
			  .collect(toList());
		
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setErrors(errorMessages);
		errorResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(errorResponseDTO, HttpStatus.OK);
		
	}
	
}
