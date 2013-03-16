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
public class SecondException extends java.lang.Exception implements Serializable {

	private java.lang.String msg;
	
	private final static long serialVersionUID = 11001L;
	
	public SecondException() {
	}	
	
	public SecondException(java.lang.String msg) {
		this.msg = msg;
	}	
	
	public java.lang.String getMsg(){
		if (msg == null) msg = "";
		return msg;
	}
	
	public void setMsg(java.lang.String v) {
		msg = v;
	}
	
	
}
