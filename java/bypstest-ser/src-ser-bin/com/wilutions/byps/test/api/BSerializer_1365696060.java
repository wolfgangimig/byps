﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Set<java.lang.Boolean>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1365696060 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1365696060();
	
	public BSerializer_1365696060() {
		super(1365696060);
	}
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final HashSet<java.lang.Boolean> arr = new HashSet<java.lang.Boolean>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Boolean obj = bbuf.getBoolean();
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.Set<java.lang.Boolean> arr = (java.util.Set<java.lang.Boolean>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (java.lang.Boolean obj : arr) {
			bbuf.putBoolean(obj != null ? (Boolean)obj : false);
		}
	}
	
}