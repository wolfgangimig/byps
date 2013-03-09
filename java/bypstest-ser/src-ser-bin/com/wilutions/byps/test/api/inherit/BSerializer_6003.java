﻿package com.wilutions.byps.test.api.inherit;

/*
 * Serializer for com.wilutions.byps.test.api.inherit.Class3
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=1

@SuppressWarnings("all")
public class BSerializer_6003 extends BSerializer_6002 {
	
	public final static BSerializer instance = new BSerializer_6003();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=24: int3 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_6003() {
		super(6003);
	}
	
	public BSerializer_6003(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final Class3 obj = (Class3)obj1;		
		super.write(obj1, bout1, version);		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.int3);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final Class3 obj = (Class3)(obj1 != null ? obj1 : bin.onObjectCreated(new Class3()));
		
		// Read base class members
		super.read(obj1, bin, version);
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.int3 = bbuf.getInt();
		
		return obj;
	}
	
}