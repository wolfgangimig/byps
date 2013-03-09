﻿package com.wilutions.byps.test.api;

/*
 * Serializer for int[]
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_100361105 extends JSerializer_Array {
	
	public final static BSerializer instance = new JSerializer_100361105();
	
	public JSerializer_100361105() {
		super(100361105);
	}
	
	
	@Override
	public Object internalRead(final BInputJson bin) throws BException {
		final BJsonObject js0 = bin.currentObject;
		
		int n0 = 0;
		n0 = js0 != null ? js0.size() : 0;
		
		final int[] arr =  new int[n0];
		bin.onObjectCreated(arr);
		
		// read
		final int[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = bin.currentObject.getInt(i0);
		}
		return arr;
		
	}
	
	@Override
	public void internalWrite(Object obj1, final BOutputJson bout, BBufferJson bbuf) throws BException {
		final int[] arr = (int[])obj1;
		
		// lengths
		final int n0 = arr.length;
		
		// write
		final int[] a0 = arr;
		bbuf.beginArray();
		for (int i0 = 0; i0 < n0; i0++) {
			bbuf.putInt(a0[i0]);
		}
		bbuf.endArray();
	}
	
}