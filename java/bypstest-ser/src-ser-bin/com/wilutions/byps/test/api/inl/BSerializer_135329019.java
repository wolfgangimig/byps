﻿package com.wilutions.byps.test.api.inl;

/*
 * Serializer for com.wilutions.byps.test.api.inl.Matrix2D
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=true
// #members=9

@SuppressWarnings("all")
public class BSerializer_135329019 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_135329019();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: _11 */ + 4		
		       /* pos=4: _12 */ + 4		
		       /* pos=8: _13 */ + 4		
		       /* pos=12: _21 */ + 4		
		       /* pos=16: _22 */ + 4		
		       /* pos=20: _23 */ + 4		
		       /* pos=24: _31 */ + 4		
		       /* pos=28: _32 */ + 4		
		       /* pos=32: _33 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_135329019() {
		super(135329019, true);
	}
	
	public BSerializer_135329019(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final Matrix2D obj = (Matrix2D)(obj1 != null ? obj1 : read(null, null, 0));		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putFloat(obj._11);
		bbuf.putFloat(obj._12);
		bbuf.putFloat(obj._13);
		bbuf.putFloat(obj._21);
		bbuf.putFloat(obj._22);
		bbuf.putFloat(obj._23);
		bbuf.putFloat(obj._31);
		bbuf.putFloat(obj._32);
		bbuf.putFloat(obj._33);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final Matrix2D obj = (Matrix2D)(obj1 != null ? obj1 : new Matrix2D());
		
		if (bin != null) {
			final BBufferBin bbuf = bin.bbuf;
			
			obj._11 = bbuf.getFloat();
			obj._12 = bbuf.getFloat();
			obj._13 = bbuf.getFloat();
			obj._21 = bbuf.getFloat();
			obj._22 = bbuf.getFloat();
			obj._23 = bbuf.getFloat();
			obj._31 = bbuf.getFloat();
			obj._32 = bbuf.getFloat();
			obj._33 = bbuf.getFloat();
			
		}
		return obj;
	}
	
}