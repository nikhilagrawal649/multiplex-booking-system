package com.multiplex.exception;

public class SeatTypeNotFoundException extends Exception {

	public SeatTypeNotFoundException() {
		super();

	}

	private static final long serialVersionUID = 1L;

	public SeatTypeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public SeatTypeNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public SeatTypeNotFoundException(String message) {
		super(message);

	}

	public SeatTypeNotFoundException(Throwable cause) {
		super(cause);
	}

}
