package com.infy.todokafka.exception;

public class ToDoItemNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public ToDoItemNotFoundException() {
		super();
		
	}

	public ToDoItemNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ToDoItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ToDoItemNotFoundException(String message) {
		super(message);
		
	}

	public ToDoItemNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
