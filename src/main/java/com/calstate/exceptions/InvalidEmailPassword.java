package com.calstate.exceptions;

public class InvalidEmailPassword extends RuntimeException {

	private static final long serialVersionUID = -7427133156501008036L;
	
	public InvalidEmailPassword(String message) {
		super(message);
	}
}
