package com.multiplex.exception;

public class MethodArgumentNotValidException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	 
	public MethodArgumentNotValidException() {
	super();
	 
	}
	 
	public MethodArgumentNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
	 
	}
	 
	public MethodArgumentNotValidException(String message, Throwable cause) {
	super(message, cause);
	 
	}
	 
	public MethodArgumentNotValidException(String message) {
	super(message);
	 
	}
	 
	public MethodArgumentNotValidException(Throwable cause) {
	super(cause);
	 
	}
	
//	
//	public MethodArgumentNotValidException getFieldErrors(MethodArgumentNotValidException message) {
//		return message;
//		 
//		}
	
	


//	public String getFieldErrors() {
//		// TODO Auto-generated method stub
//		return "" ;
//	}

//	public Object getFieldErrors() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	 
	}
	