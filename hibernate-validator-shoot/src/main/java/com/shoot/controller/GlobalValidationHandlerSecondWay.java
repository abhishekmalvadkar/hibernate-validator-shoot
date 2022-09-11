package com.shoot.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shoot.dto.ErrorResponseDTO;

/**
 * @author ABHISHEK MALVADKAR
 * Note : This is the second way to handle bean validation violation at single place
 * 		  use anyone of these two way , I have committed both way for reference only
 *        you can put this MethodArgumentNotValidException exception in your global exception handler class
 * @see {@link GlobalValidationHandlerFirstWay}*
 */

@ControllerAdvice
public class GlobalValidationHandlerSecondWay {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDTO> handleBeanValidationViolation(MethodArgumentNotValidException ex) {
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
