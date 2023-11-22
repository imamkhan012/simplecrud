package com.blogapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogapi.controller.ResponseApi;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseApi> exceptionHandller(ResourceNotFoundException ex)
	{
		String m=ex.getMessage();
		ResponseApi responseApi = new ResponseApi(m,false);
		return new ResponseEntity<ResponseApi>(responseApi, HttpStatus.NOT_FOUND);
		
				
	}

}
