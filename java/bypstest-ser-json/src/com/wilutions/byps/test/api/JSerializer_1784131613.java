package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.inl.Actor[]
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_1784131613 extends JSerializer_Array {
	
	public final static BSerializer instance = new JSerializer_1784131613();
	
	public JSerializer_1784131613() {
		super(1784131613);
	}
	
	
	@Override
	public Object internalRead(final BInputJson bin) throws BException {
		final BJsonObject js0 = bin.currentObject;
		
		int n0 = 0;
		n0 = js0 != null ? js0.size() : 0;
		
		final com.wilutions.byps.test.api.inl.Actor[] arr =  new com.wilutions.byps.test.api.inl.Actor[n0];
		bin.onObjectCreated(arr);
		
		// read
		final com.wilutions.byps.test.api.inl.Actor[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = (com.wilutions.byps.test.api.inl.Actor)bin.readObj(i0, false, null);
		}
		return arr;
		
	}
	
	@Override
	public void internalWrite(Object obj1, final BOutputJson bout, BBufferJson bbuf) throws BException {
		final com.wilutions.byps.test.api.inl.Actor[] arr = (com.wilutions.byps.test.api.inl.Actor[])obj1;
		
		// lengths
		final int n0 = arr.length;
		
		// write
		final com.wilutions.byps.test.api.inl.Actor[] a0 = arr;
		bbuf.beginArray();
		for (int i0 = 0; i0 < n0; i0++) {
			bout.writeObj(null, a0[i0], false, null);
		}
		bbuf.endArray();
	}
	
}
