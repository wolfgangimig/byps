package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public class FirstException extends java.lang.Exception implements Serializable {

	public java.util.List<java.lang.String> listOfStrings;
	private java.lang.Throwable cause;
	
	private final static long serialVersionUID = 11000L;
	
	public FirstException() {
	}	
	
	public FirstException(java.util.List<java.lang.String> listOfStrings, java.lang.Throwable cause) {
		this.listOfStrings = listOfStrings;
		this.cause = cause;
	}	
	
	public java.lang.Throwable getCause(){
		return cause;
	}
	
	public void setCause(java.lang.Throwable v) {
		cause = v;
	}
	
	
}
