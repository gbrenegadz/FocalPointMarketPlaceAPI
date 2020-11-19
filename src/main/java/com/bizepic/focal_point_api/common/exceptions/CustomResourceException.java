package com.bizepic.focal_point_api.common.exceptions;

public class CustomResourceException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomResourceException(String errorMessage) {
        super(errorMessage);
    }
	
	public CustomResourceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
