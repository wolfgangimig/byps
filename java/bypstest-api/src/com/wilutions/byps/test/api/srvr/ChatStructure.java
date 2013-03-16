package com.wilutions.byps.test.api.srvr;

import java.io.Serializable;

/**
 */
public class ChatStructure implements Serializable {
	
	private final static long serialVersionUID = 7007;
	
	public String msg;
	public double sentAt;
	public double receivedAt;
	
}
