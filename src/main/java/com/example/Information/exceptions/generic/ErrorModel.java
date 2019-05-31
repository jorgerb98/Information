
package com.example.Information.exceptions.generic;

public class ErrorModel {

	private String error;

	public static ErrorModel of(String errorMessage) {
		ErrorModel errorModel = new ErrorModel();
		errorModel.error = errorMessage;
		return errorModel;
	}

	public String getError() {
		return error;
	}

}
