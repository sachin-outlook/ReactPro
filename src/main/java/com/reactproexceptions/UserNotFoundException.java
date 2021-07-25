package com.reactproexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1741045902721845486L;

	public UserNotFoundException(String message) {
		super(message);
		
	}

	
}
