﻿package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public class ChatStructure implements Serializable {

	public java.lang.String msg;
	public double sentAt;
	public double receivedAt;
	
	private final static long serialVersionUID = 7007L;
	
	public ChatStructure() {
	}	
	
	public ChatStructure(java.lang.String msg, double sentAt, double receivedAt) {
		this.msg = msg;
		this.sentAt = sentAt;
		this.receivedAt = receivedAt;
	}	
	
}
