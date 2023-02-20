package com.multiplex.exception;

public class BookingNotAddedException extends Exception {
	private static final long serialVersionUID = 1L;

	public BookingNotAddedException() {

	}

	public BookingNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public BookingNotAddedException(String message, Throwable cause) {
		super(message, cause);

	}

	public BookingNotAddedException(String message) {
		super(message);

	}

	public BookingNotAddedException(Throwable cause) {
		super(cause);
	}

}
