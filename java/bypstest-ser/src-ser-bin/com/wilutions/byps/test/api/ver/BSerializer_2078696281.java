﻿package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BStub_EvolveIF
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class BSerializer_2078696281 extends BSerializer_16 {
	
	public final static BSerializer instance = new BSerializer_2078696281();
	
	public BSerializer_2078696281() {
		super(2078696281);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_EvolveIF(transport);
	}
	
}