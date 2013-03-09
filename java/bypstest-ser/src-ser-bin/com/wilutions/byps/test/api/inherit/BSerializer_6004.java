﻿package com.wilutions.byps.test.api.inherit;

/*
 * Serializer for com.wilutions.byps.test.api.inherit.Class1Collections
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=3

@SuppressWarnings("all")
public class BSerializer_6004 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_6004();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: list1 */ + 4		
		       /* pos=4: map1 */ + 4		
		       /* pos=8: set1 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_6004() {
		super(6004);
	}
	
	public BSerializer_6004(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final Class1Collections obj = (Class1Collections)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.list1, false, com.wilutions.byps.test.api.BSerializer_317887457.instance);
		bout.writeObj(obj.map1, false, com.wilutions.byps.test.api.BSerializer_981592984.instance);
		bout.writeObj(obj.set1, false, com.wilutions.byps.test.api.BSerializer_2114305573.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final Class1Collections obj = (Class1Collections)(obj1 != null ? obj1 : bin.onObjectCreated(new Class1Collections()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.list1 = (java.util.List<com.wilutions.byps.test.api.inherit.Class1>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_317887457.instance);
		obj.map1 = (java.util.Map<java.lang.String,com.wilutions.byps.test.api.inherit.Class1>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_981592984.instance);
		obj.set1 = (java.util.Set<com.wilutions.byps.test.api.inherit.Class1>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2114305573.instance);
		
		return obj;
	}
	
}