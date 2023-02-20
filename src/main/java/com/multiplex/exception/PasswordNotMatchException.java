package com.multiplex.exception;

public class PasswordNotMatchException extends Exception{

	private static final long serialVersionUID = 1L;

	public PasswordNotMatchException() {
		
	}

	public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PasswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PasswordNotMatchException(String message) {
		super(message);
		
	}

	public PasswordNotMatchException(Throwable cause) {
		super(cause);
		
	}
	

}