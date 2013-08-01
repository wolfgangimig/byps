﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.TreeSet<java.lang.Integer>
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerListJson DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_855786668 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_855786668();
	
	public JSerializer_855786668() {
		super(855786668);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final TreeSet<java.lang.Integer> arr = new TreeSet<java.lang.Integer>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Integer obj = bin.currentObject.getInt(i0);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.TreeSet<java.lang.Integer> arr = (java.util.TreeSet<java.lang.Integer>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.lang.Integer obj : arr) {
			bbuf.putInt(obj != null ? (Integer)obj : 0);
		}
		bbuf.endArray();
	}
	
}
