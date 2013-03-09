﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1398598597 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_1398598597();
	
	public JSerializer_1398598597() {
		super(1398598597);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<List<com.wilutions.byps.test.api.inl.Actor>> arr = new ArrayList<List<com.wilutions.byps.test.api.inl.Actor>>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.util.List<com.wilutions.byps.test.api.inl.Actor> obj = (java.util.List<com.wilutions.byps.test.api.inl.Actor>)bin.readObj(i0, false, com.wilutions.byps.test.api.JSerializer_494001343.instance);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>> arr = (java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.util.List<com.wilutions.byps.test.api.inl.Actor> obj : arr) {
			bout.writeObj(null, obj, false, com.wilutions.byps.test.api.JSerializer_494001343.instance);
		}
		bbuf.endArray();
	}
	
}