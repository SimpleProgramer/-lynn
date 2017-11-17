package com.lynn.net.commons.exception;

import com.lynn.net.commons.constants.Constants;

public class CustomException extends Exception{

	public CustomException(String message) {
		super();
	}
	public int getStatusCode() {return Constants.RESP_STATUS_INTERNAL_ERROR;};
}
