package com.demo.flightBooking.exceptionhandler;

public class InvlalidParametersException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1975344731832696985L;

	public InvlalidParametersException(String msg) {
		super(msg);
	}
}
