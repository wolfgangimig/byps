package com.wilutions.byps.test.api.remote;


public class SecondException extends Throwable {

	private static final long serialVersionUID = 11001L;

	public SecondException(String msg) {
		this.msg = msg;
	}
	
	private String msg;
	
	
}
