﻿package com.wilutions.byps.test.api.list;

/*
 * Serializer for com.wilutions.byps.test.api.list.ListListTypes
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
public class BSerializer_3002 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_3002();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: int2 */ + 4		
		       /* pos=4: int3 */ + 4		
		       /* pos=8: int24 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_3002() {
		super(3002);
	}
	
	public BSerializer_3002(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final ListListTypes obj = (ListListTypes)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.int2, false, com.wilutions.byps.test.api.BSerializer_1746702954.instance);
		bout.writeObj(obj.int24, false, com.wilutions.byps.test.api.BSerializer_1865834185.instance);
		bout.writeObj(obj.int3, false, com.wilutions.byps.test.api.BSerializer_1633500852.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final ListListTypes obj = (ListListTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new ListListTypes()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.int2 = (java.util.List<java.util.List<java.lang.Integer>>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1746702954.instance);
		obj.int24 = (java.util.List<java.util.List<int[][][][]>>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1865834185.instance);
		obj.int3 = (java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1633500852.instance);
		
		return obj;
	}
	
}