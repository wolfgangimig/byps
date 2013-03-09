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
public class JSerializer_135329019 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_135329019();
	
	
	public JSerializer_135329019() {
		super(135329019, true);
	}
	
	public JSerializer_135329019(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final Matrix2D obj = (Matrix2D)(obj1 != null ? obj1 : read(null, null, 0));		
		bbuf.putFloat("_11", obj._11);
		bbuf.putFloat("_12", obj._12);
		bbuf.putFloat("_13", obj._13);
		bbuf.putFloat("_21", obj._21);
		bbuf.putFloat("_22", obj._22);
		bbuf.putFloat("_23", obj._23);
		bbuf.putFloat("_31", obj._31);
		bbuf.putFloat("_32", obj._32);
		bbuf.putFloat("_33", obj._33);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final Matrix2D obj = (Matrix2D)(obj1 != null ? obj1 : new Matrix2D());
		
		if (bin != null) {
			final BJsonObject js = bin.currentObject;
			obj._11 = js.getFloat("_11");
			obj._12 = js.getFloat("_12");
			obj._13 = js.getFloat("_13");
			obj._21 = js.getFloat("_21");
			obj._22 = js.getFloat("_22");
			obj._23 = js.getFloat("_23");
			obj._31 = js.getFloat("_31");
			obj._32 = js.getFloat("_32");
			obj._33 = js.getFloat("_33");
			
		}
		return obj;
	}
	
}