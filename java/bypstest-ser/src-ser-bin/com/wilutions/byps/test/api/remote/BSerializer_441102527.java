﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setInt
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class BSerializer_441102527 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_441102527();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: result */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_441102527() {
		super(441102527);
	}
	
	public BSerializer_441102527(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_RemotePrimitiveTypes_setInt obj = (BResult_RemotePrimitiveTypes_setInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_setInt()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		// void result		
		return obj;
	}
	
}