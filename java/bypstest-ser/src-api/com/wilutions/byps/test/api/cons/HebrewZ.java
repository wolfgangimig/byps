package com.wilutions.byps.test.api.cons;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * @BSerializable 
 * @BSerializable 
*/
@SuppressWarnings("all")
public class HebrewZ implements BSerializable {

	private java.lang.String core;
	
	private final static long serialVersionUID = 1039162031L;
	
	public HebrewZ() {
	}	
	
	public HebrewZ(java.lang.String core) {
		this.core = core;
	}	
	
	public java.lang.String getCore(){
		if (core == null) core = "";
		return core;
	}
	
	public void setCore(java.lang.String v) {
		core = v;
	}
	
	
}
