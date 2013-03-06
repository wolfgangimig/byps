package com.wilutions.byps.test.api;

/*
 * Serializer for float[]
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_766441794 extends JSerializer_Array {
	
	public final static BSerializer instance = new JSerializer_766441794();
	
	public JSerializer_766441794() {
		super(766441794);
	}
	
	
	@Override
	public Object internalRead(final BInputJson bin) throws BException {
		final BJsonObject js0 = bin.currentObject;
		
		int n0 = 0;
		n0 = js0 != null ? js0.size() : 0;
		
		final float[] arr =  new float[n0];
		bin.onObjectCreated(arr);
		
		// read
		final float[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = bin.currentObject.getFloat(i0);
		}
		return arr;
		
	}
	
	@Override
	public void internalWrite(Object obj1, final BOutputJson bout, BBufferJson bbuf) throws BException {
		final float[] arr = (float[])obj1;
		
		// lengths
		final int n0 = arr.length;
		
		// write
		final float[] a0 = arr;
		bbuf.beginArray();
		for (int i0 = 0; i0 < n0; i0++) {
			bbuf.putFloat(a0[i0]);
		}
		bbuf.endArray();
	}
	
}
