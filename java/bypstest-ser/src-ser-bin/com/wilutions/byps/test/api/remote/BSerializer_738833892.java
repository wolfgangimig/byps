﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysObject
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=3

@SuppressWarnings("all")
public class BSerializer_738833892 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_738833892();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: arr2 */ + 4		
		       /* pos=4: arr3 */ + 4		
		       /* pos=8: arr4 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_738833892() {
		super(738833892);
	}
	
	public BSerializer_738833892(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteArrayTypes23_sendArraysObject obj = (BRequest_RemoteArrayTypes23_sendArraysObject)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.arr2, false, com.wilutions.byps.test.api.BSerializer_340213335.instance);
		bout.writeObj(obj.arr3, false, com.wilutions.byps.test.api.BSerializer_527503353.instance);
		bout.writeObj(obj.arr4, false, com.wilutions.byps.test.api.BSerializer_124584219.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteArrayTypes23_sendArraysObject obj = (BRequest_RemoteArrayTypes23_sendArraysObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysObject()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.arr2 = (java.lang.Object[][])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_340213335.instance);
		obj.arr3 = (java.lang.Object[][][])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_527503353.instance);
		obj.arr4 = (java.lang.Object[][][][])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_124584219.instance);
		
		return obj;
	}
	
}