﻿package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_766441794
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
public class BSerializer_1517001317 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1517001317();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: result */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1517001317() {
		super(1517001317);
	}
	
	public BSerializer_1517001317(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BResult_766441794 obj = (BResult_766441794)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_766441794 obj = (BResult_766441794)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_766441794()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (float[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
		
		return obj;
	}
	
}
