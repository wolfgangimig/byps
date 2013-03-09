﻿package com.wilutions.byps.test.api;

/*
 * Serializer for int[]
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class BSerializer_100361105 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_100361105();
	
	public BSerializer_100361105() {
		super(100361105);
	}
	
	@Override
	public int size(Object obj, BBinaryModel bmodel) throws BException { 
		final int elementSize = 4;
		final int[] arr = (int[])obj;
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
		final int[] arr =  new int[n0];
		bin.onObjectCreated(arr);
		
		// read
		final int[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = bbuf.getInt();
		}
		
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final int version) throws BException {
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		
		final int[] arr = (int[])obj1;
		
		// lengths
		final int n0 = arr.length;
		bbuf.putLength(n0);
		
		// write
		final int[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			bbuf.putInt(a0[i0]);
		}
	}
	
}