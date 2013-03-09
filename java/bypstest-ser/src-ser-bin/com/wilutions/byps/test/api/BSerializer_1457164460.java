﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Set<java.lang.Long>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1457164460 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1457164460();
	
	public BSerializer_1457164460() {
		super(1457164460);
	}
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final HashSet<java.lang.Long> arr = new HashSet<java.lang.Long>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Long obj = bbuf.getLong();
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.Set<java.lang.Long> arr = (java.util.Set<java.lang.Long>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (java.lang.Long obj : arr) {
			bbuf.putLong(obj != null ? (Long)obj : 0L);
		}
	}
	
}