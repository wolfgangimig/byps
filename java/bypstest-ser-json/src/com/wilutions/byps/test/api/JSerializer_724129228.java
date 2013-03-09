﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<java.util.TreeSet<java.lang.Integer>>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_724129228 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_724129228();
	
	public JSerializer_724129228() {
		super(724129228);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<TreeSet<java.lang.Integer>> arr = new ArrayList<TreeSet<java.lang.Integer>>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.util.TreeSet<java.lang.Integer> obj = (java.util.TreeSet<java.lang.Integer>)bin.readObj(i0, false, com.wilutions.byps.test.api.JSerializer_855786668.instance);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.List<java.util.TreeSet<java.lang.Integer>> arr = (java.util.List<java.util.TreeSet<java.lang.Integer>>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.util.TreeSet<java.lang.Integer> obj : arr) {
			bout.writeObj(null, obj, false, com.wilutions.byps.test.api.JSerializer_855786668.instance);
		}
		bbuf.endArray();
	}
	
}