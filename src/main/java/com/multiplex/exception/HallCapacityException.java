package com.multiplex.exception;
 
public class HallCapacityException extends RuntimeException{
 
private static final long serialVersionUID = 1L;
 
public HallCapacityException() {
super();
 
}
 
public HallCapacityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
super(message, cause, enableSuppression, writableStackTrace);
 
}
 
public HallCapacityException(String message, Throwable cause) {
super(message, cause);
 
}
 
public HallCapacityException(String message) {
super(message);
 
}
 
public HallCapacityException(Throwable cause) {
super(cause);
 
}
 
}

