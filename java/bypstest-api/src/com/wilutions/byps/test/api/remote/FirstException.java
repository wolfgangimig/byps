package com.wilutions.byps.test.api.remote;

import java.util.List;

import java.io.Serializable;


public class FirstException extends Throwable implements Serializable {

	private static final long serialVersionUID = 11000L;

	// kann msg und cause nicht serialisieren.
	// Sie sind in Throwable final und können nicht über internalRead eingelesen werden.
	public FirstException(List<String> listOfStrings, Throwable cause) {
		this.listOfStrings = listOfStrings;
		this.cause = cause;
	}
	
	public FirstException() {
		
	}
	
	public List<String> listOfStrings;
	
	// Muss Serializable implementieren (generiert) oder BException sein
	private Throwable cause;

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	
	
	
}
