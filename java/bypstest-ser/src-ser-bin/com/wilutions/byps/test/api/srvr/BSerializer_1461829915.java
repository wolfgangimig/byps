﻿package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BRequest_ClientIF_incrementInt
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
public class BSerializer_1461829915 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1461829915();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: a */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1461829915() {
		super(1461829915);
	}
	
	public BSerializer_1461829915(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_ClientIF_incrementInt obj = (BRequest_ClientIF_incrementInt)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.a);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_ClientIF_incrementInt obj = (BRequest_ClientIF_incrementInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_incrementInt()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.a = bbuf.getInt();
		
		return obj;
	}
	
}
