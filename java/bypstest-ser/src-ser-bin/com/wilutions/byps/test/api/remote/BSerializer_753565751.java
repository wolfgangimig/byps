﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setDouble
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
public class BSerializer_753565751 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_753565751();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: v */ + 8		
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_753565751() {
		super(753565751);
	}
	
	public BSerializer_753565751(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemotePrimitiveTypes_setDouble obj = (BRequest_RemotePrimitiveTypes_setDouble)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putDouble(obj.v);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemotePrimitiveTypes_setDouble obj = (BRequest_RemotePrimitiveTypes_setDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setDouble()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.v = bbuf.getDouble();
		
		return obj;
	}
	
}