package com.multiplex.exception;

public class HallException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public HallException() {
		super();
	}

	public HallException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HallException(String message, Throwable cause) {
		super(message, cause);
	}

	public HallException(String message) {
		super(message);
	}

	public HallException(Throwable cause) {
		super(cause);
	}
}
