﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setBool
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
public class BSerializer_202005372 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_202005372();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: v */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_202005372() {
		super(202005372);
	}
	
	public BSerializer_202005372(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteArrayTypes4dim_setBool obj = (BRequest_RemoteArrayTypes4dim_setBool)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.v, false, com.wilutions.byps.test.api.BSerializer_945713488.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteArrayTypes4dim_setBool obj = (BRequest_RemoteArrayTypes4dim_setBool)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setBool()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.v = (boolean[][][][])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_945713488.instance);
		
		return obj;
	}
	
}