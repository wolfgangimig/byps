﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setBoolean1
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
public class BSerializer_1882657404 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1882657404();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: boolean1 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1882657404() {
		super(1882657404);
	}
	
	public BSerializer_1882657404(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteListTypes_setBoolean1 obj = (BRequest_RemoteListTypes_setBoolean1)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.boolean1, false, com.wilutions.byps.test.api.BSerializer_1617670280.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteListTypes_setBoolean1 obj = (BRequest_RemoteListTypes_setBoolean1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setBoolean1()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.boolean1 = (java.util.List<java.lang.Boolean>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1617670280.instance);
		
		return obj;
	}
	
}
