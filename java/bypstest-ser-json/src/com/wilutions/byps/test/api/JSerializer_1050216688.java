﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<java.lang.Long>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1050216688 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_1050216688();
	
	public JSerializer_1050216688() {
		super(1050216688);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<java.lang.Long> arr = new ArrayList<java.lang.Long>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Long obj = bin.currentObject.getLong(i0);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.List<java.lang.Long> arr = (java.util.List<java.lang.Long>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.lang.Long obj : arr) {
			bbuf.putLong(obj != null ? (Long)obj : 0L);
		}
		bbuf.endArray();
	}
	
}