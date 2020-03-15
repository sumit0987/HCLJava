package com.demo.onlineshopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5900611961891604806L;

	public RecordNotFoundException(String msg) {
		super(msg);
	}
}
