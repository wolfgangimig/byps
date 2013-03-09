﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Set<com.wilutions.byps.test.api.inherit.Class1>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_2114305573 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_2114305573();
	
	public JSerializer_2114305573() {
		super(2114305573);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final HashSet<com.wilutions.byps.test.api.inherit.Class1> arr = new HashSet<com.wilutions.byps.test.api.inherit.Class1>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			com.wilutions.byps.test.api.inherit.Class1 obj = (com.wilutions.byps.test.api.inherit.Class1)bin.readObj(i0, false, null);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.Set<com.wilutions.byps.test.api.inherit.Class1> arr = (java.util.Set<com.wilutions.byps.test.api.inherit.Class1>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (com.wilutions.byps.test.api.inherit.Class1 obj : arr) {
			bout.writeObj(null, obj, false, null);
		}
		bbuf.endArray();
	}
	
}