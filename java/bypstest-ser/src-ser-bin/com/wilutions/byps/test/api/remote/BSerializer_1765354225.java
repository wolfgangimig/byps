﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setPrimitiveTypes
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class BSerializer_1765354225 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1765354225();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: v */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1765354225() {
		super(1765354225);
	}
	
	public BSerializer_1765354225(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteArrayTypes1dim_setPrimitiveTypes obj = (BRequest_RemoteArrayTypes1dim_setPrimitiveTypes)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.v, false, com.wilutions.byps.test.api.BSerializer_801243127.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteArrayTypes1dim_setPrimitiveTypes obj = (BRequest_RemoteArrayTypes1dim_setPrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.v = (com.wilutions.byps.test.api.prim.PrimitiveTypes[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_801243127.instance);
		
		return obj;
	}
	
}
