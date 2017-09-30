package com.mc437.produshow.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.config.exception.ErrorResponse;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value={GeneralException.class})
	ErrorResponse handleGeneralException (GeneralException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorCode());
		return errorResponse;
	}
	
}
