﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt4
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
public class BSerializer_1360809952 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1360809952();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: int4 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1360809952() {
		super(1360809952);
	}
	
	public BSerializer_1360809952(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteListTypes_setInt4 obj = (BRequest_RemoteListTypes_setInt4)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.int4, false, com.wilutions.byps.test.api.BSerializer_1633500852.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteListTypes_setInt4 obj = (BRequest_RemoteListTypes_setInt4)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setInt4()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.int4 = (java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1633500852.instance);
		
		return obj;
	}
	
}