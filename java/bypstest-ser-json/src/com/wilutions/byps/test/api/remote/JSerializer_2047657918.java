﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_throwLastException
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

@SuppressWarnings("all")
public class JSerializer_2047657918 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2047657918();
	
	
	public JSerializer_2047657918() {
		super(2047657918);
	}
	
	public JSerializer_2047657918(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteStreams_throwLastException obj = (BRequest_RemoteStreams_throwLastException)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_throwLastException()));
		
		return obj;
	}
	
}