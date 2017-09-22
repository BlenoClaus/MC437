package com.mc437.produshow;

public class GeneralException extends Exception {

	private String errorCode;
	
	public GeneralException(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
