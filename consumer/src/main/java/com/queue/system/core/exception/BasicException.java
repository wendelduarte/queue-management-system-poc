package com.queue.system.core.exception;

public class BasicException extends RuntimeException {
	
	public BasicException (Throwable exception) {
		super(exception.getMessage(), exception.getCause());
	}
	
	public BasicException(String msg) {
		super(msg);
	}
}