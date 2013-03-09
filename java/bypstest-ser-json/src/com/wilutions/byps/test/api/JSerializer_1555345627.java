﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<java.lang.Double>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1555345627 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_1555345627();
	
	public JSerializer_1555345627() {
		super(1555345627);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<java.lang.Double> arr = new ArrayList<java.lang.Double>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Double obj = bin.currentObject.getDouble(i0);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.List<java.lang.Double> arr = (java.util.List<java.lang.Double>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.lang.Double obj : arr) {
			bbuf.putDouble(obj != null ? (Double)obj : 0.0);
		}
		bbuf.endArray();
	}
	
}