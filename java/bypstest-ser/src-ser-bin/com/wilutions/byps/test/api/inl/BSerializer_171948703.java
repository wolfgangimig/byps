﻿package com.wilutions.byps.test.api.inl;

/*
 * Serializer for com.wilutions.byps.test.api.inl.Actor
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=2

@SuppressWarnings("all")
public class BSerializer_171948703 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_171948703();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: shape */ + 4		
		       /* pos=4: position */ + 4		
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_171948703() {
		super(171948703);
	}
	
	public BSerializer_171948703(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final Actor obj = (Actor)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.position, false, com.wilutions.byps.test.api.inl.BSerializer_135329019.instance);
		bout.writeObj(obj.shape, false, com.wilutions.byps.test.api.BSerializer_2049740106.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final Actor obj = (Actor)(obj1 != null ? obj1 : bin.onObjectCreated(new Actor()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.position = (com.wilutions.byps.test.api.inl.Matrix2D)bin.readObj(false, com.wilutions.byps.test.api.inl.BSerializer_135329019.instance);
		obj.shape = (com.wilutions.byps.test.api.inl.Point2D[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2049740106.instance);
		
		return obj;
	}
	
}