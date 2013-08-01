﻿package com.wilutions.byps.test.api;

/*
 * Serializer for short[]
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerArray DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class BSerializer_2067161310 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_2067161310();
	
	public BSerializer_2067161310() {
		super(2067161310);
	}
	
	@Override
	public int size(Object obj, BBinaryModel bmodel) throws BException { 
		final int elementSize = 2;
		final short[] arr = (short[])obj;
		int n = arr.length;
		return bmodel.computeArrayWireSize(elementSize, n);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		
		// lengths
		final int n0 = bbuf.getLength();
		
		// create array
		final short[] arr =  new short[n0];
		bin.onObjectCreated(arr);
		
		// read
		final short[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = bbuf.getShort();
		}
		
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final int version) throws BException {
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		
		final short[] arr = (short[])obj1;
		
		// lengths
		final int n0 = arr.length;
		bbuf.putLength(n0);
		
		// write
		final short[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			bbuf.putShort(a0[i0]);
		}
	}
	
}
