package com.queue.system.core.exception;

public class TooManyRequestsException extends BasicException{

	public TooManyRequestsException(String msg) {
		super(msg);
	}
}