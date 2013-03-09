﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<java.lang.Short>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1997002548 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1997002548();
	
	public BSerializer_1997002548() {
		super(1997002548);
	}
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final ArrayList<java.lang.Short> arr = new ArrayList<java.lang.Short>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Short obj = bbuf.getShort();
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.List<java.lang.Short> arr = (java.util.List<java.lang.Short>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (java.lang.Short obj : arr) {
			bbuf.putShort(obj != null ? (Short)obj : ((short)0));
		}
	}
	
}