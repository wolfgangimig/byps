﻿package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BStub_ClientIF
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_1784257353 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_1784257353();
	
	public JSerializer_1784257353() {
		super(1784257353);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_ClientIF(transport);
	}
	
}