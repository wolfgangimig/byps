﻿package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1174971318
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
public class BSerializer_994835305 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_994835305();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: result */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_994835305() {
		super(994835305);
	}
	
	public BSerializer_994835305(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BResult_1174971318 obj = (BResult_1174971318)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, com.wilutions.byps.test.api.BSerializer_1174971318.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_1174971318 obj = (BResult_1174971318)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1174971318()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (java.util.List<byte[]>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1174971318.instance);
		
		return obj;
	}
	
}