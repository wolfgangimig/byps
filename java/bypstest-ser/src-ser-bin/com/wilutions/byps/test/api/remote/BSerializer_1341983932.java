﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class BSerializer_1341983932 extends BSerializer_16 {
	
	public final static BSerializer instance = new BSerializer_1341983932();
	
	public BSerializer_1341983932() {
		super(1341983932);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemotePrimitiveTypes(transport);
	}
	
}