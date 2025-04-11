package com.user.exceptions;
public class UserServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserServiceException(String errorMeasg){
		super(errorMeasg,null,false,false);
	}

	public synchronized Throwable fillInStacktrace() {
		return this;
	}
	
	@Override
	public String toString() {
		return getMessage();
	}
}
