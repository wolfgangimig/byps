﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Set<java.lang.Float>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1898022288 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_1898022288();
	
	public JSerializer_1898022288() {
		super(1898022288);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final HashSet<java.lang.Float> arr = new HashSet<java.lang.Float>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Float obj = bin.currentObject.getFloat(i0);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.Set<java.lang.Float> arr = (java.util.Set<java.lang.Float>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.lang.Float obj : arr) {
			bbuf.putFloat(obj != null ? (Float)obj : 0.0f);
		}
		bbuf.endArray();
	}
	
}