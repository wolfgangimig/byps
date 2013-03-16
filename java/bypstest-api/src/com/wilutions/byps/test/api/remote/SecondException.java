package com.wilutions.byps.test.api.remote;

import java.io.Serializable;


public class SecondException extends Throwable implements Serializable {

	private static final long serialVersionUID = 11001L;

	public SecondException(String msg) {
		this.msg = msg;
	}
	
	public SecondException() {
		this.msg = "";
	}
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
