package com.wilutions.byps.test.api;

/*
 * Serializer for short[]
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_2067161310 extends JSerializer_Array {
	
	public final static BSerializer instance = new JSerializer_2067161310();
	
	public JSerializer_2067161310() {
		super(2067161310);
	}
	
	
	@Override
	public Object internalRead(final BInputJson bin) throws BException {
		final BJsonObject js0 = bin.currentObject;
		
		int n0 = 0;
		n0 = js0 != null ? js0.size() : 0;
		
		final short[] arr =  new short[n0];
		bin.onObjectCreated(arr);
		
		// read
		final short[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = bin.currentObject.getShort(i0);
		}
		return arr;
		
	}
	
	@Override
	public void internalWrite(Object obj1, final BOutputJson bout, BBufferJson bbuf) throws BException {
		final short[] arr = (short[])obj1;
		
		// lengths
		final int n0 = arr.length;
		
		// write
		final short[] a0 = arr;
		bbuf.beginArray();
		for (int i0 = 0; i0 < n0; i0++) {
			bbuf.putShort(a0[i0]);
		}
		bbuf.endArray();
	}
	
}
