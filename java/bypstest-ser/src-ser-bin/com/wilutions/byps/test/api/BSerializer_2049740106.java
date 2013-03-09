﻿package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.inl.Point2D[]
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class BSerializer_2049740106 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_2049740106();
	
	public BSerializer_2049740106() {
		super(2049740106);
	}
	
	@Override
	public int size(Object obj, BBinaryModel bmodel) throws BException { 
		final int elementSize = bmodel.pointerSize;
		final com.wilutions.byps.test.api.inl.Point2D[] arr = (com.wilutions.byps.test.api.inl.Point2D[])obj;
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
		final com.wilutions.byps.test.api.inl.Point2D[] arr =  new com.wilutions.byps.test.api.inl.Point2D[n0];
		bin.onObjectCreated(arr);
		
		// read
		final com.wilutions.byps.test.api.inl.Point2D[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			a0[i0] = (com.wilutions.byps.test.api.inl.Point2D)bin.readObj(false, com.wilutions.byps.test.api.inl.BSerializer_1835035436.instance);
		}
		
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, final int version) throws BException {
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		
		final com.wilutions.byps.test.api.inl.Point2D[] arr = (com.wilutions.byps.test.api.inl.Point2D[])obj1;
		
		// lengths
		final int n0 = arr.length;
		bbuf.putLength(n0);
		
		// write
		final com.wilutions.byps.test.api.inl.Point2D[] a0 = arr;
		for (int i0 = 0; i0 < n0; i0++) {
			bout.writeObj(a0[i0], false, com.wilutions.byps.test.api.inl.BSerializer_1835035436.instance);
		}
	}
	
}