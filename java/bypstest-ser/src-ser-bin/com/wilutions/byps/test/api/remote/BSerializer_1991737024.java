﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setInt2
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
public class BSerializer_1991737024 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1991737024();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: int2 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1991737024() {
		super(1991737024);
	}
	
	public BSerializer_1991737024(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteSetTypes_setInt2 obj = (BRequest_RemoteSetTypes_setInt2)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.int2, false, com.wilutions.byps.test.api.BSerializer_1406124761.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteSetTypes_setInt2 obj = (BRequest_RemoteSetTypes_setInt2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setInt2()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.int2 = (java.util.Set<int[]>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1406124761.instance);
		
		return obj;
	}
	
}
