﻿package com.wilutions.byps.test.api.cons;

/*
 * Serializer for com.wilutions.byps.test.api.cons.AllTypesC
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=18

@SuppressWarnings("all")
public class BSerializer_619221761 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_619221761();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: bool1s */ + 4		
		       /* pos=4: bool2s */ + 4		
		       /* pos=8: byte1s */ + 1		
		       /* padding */ + 1		
		       /* pos=10: char1s */ + 2		
		       /* pos=12: stringNull */ + 4		
		       /* pos=16: char2s */ + 2		
		       /* pos=18: short1s */ + 2		
		       /* pos=20: int1s */ + 4		
		       /* pos=24: long1s */ + 8		
		       /* pos=32: float1s */ + 4		
		       /* padding */ + 4		
		       /* pos=40: double1s */ + 8		
		       /* pos=48: string1s */ + 4		
		       /* pos=52: ALL */ + 4		
		       /* pos=56: arrInt */ + 4		
		       /* pos=60: arrInt4 */ + 4		
		       /* pos=64: arrStrings */ + 4		
		       /* pos=68: arrStrings4 */ + 4		
		       /* pos=72: arrALL */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_619221761() {
		super(619221761);
	}
	
	public BSerializer_619221761(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final AllTypesC obj = (AllTypesC)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final AllTypesC obj = (AllTypesC)(obj1 != null ? obj1 : bin.onObjectCreated(new AllTypesC()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		
		return obj;
	}
	
}