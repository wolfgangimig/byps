﻿package com.wilutions.byps.test.api.cons;

/*
 * Serializer for com.wilutions.byps.test.api.cons.HebrewZ
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
public class BSerializer_1039162031 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1039162031();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: core */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1039162031() {
		super(1039162031);
	}
	
	public BSerializer_1039162031(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final HebrewZ obj = (HebrewZ)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putString(obj.getCore());
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final HebrewZ obj = (HebrewZ)(obj1 != null ? obj1 : bin.onObjectCreated(new HebrewZ()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.setCore(bbuf.getString());
		
		return obj;
	}
	
}