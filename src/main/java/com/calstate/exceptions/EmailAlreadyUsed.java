package com.calstate.exceptions;

public class EmailAlreadyUsed extends RuntimeException {

	private static final long serialVersionUID = 583026745305039959L;

	public EmailAlreadyUsed(String message) {
		super(message);
	}
}
