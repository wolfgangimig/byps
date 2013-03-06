package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BStub_ClientIF
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class BSerializer_1784257353 extends BSerializer_16 {
	
	public final static BSerializer instance = new BSerializer_1784257353();
	
	public BSerializer_1784257353() {
		super(1784257353);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_ClientIF(transport);
	}
	
}
