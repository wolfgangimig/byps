﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1930448581 extends BSerializer_13 {
	
	public final static BSerializer instance = new BSerializer_1930448581();
	
	public BSerializer_1930448581() {
		super(1930448581);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final HashMap<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> map = new HashMap<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>();
		bin.onObjectCreated(map);
		int n = bbuf.getLength();
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Integer key = bbuf.getInt();
			com.wilutions.byps.test.api.inl.Actor value = (com.wilutions.byps.test.api.inl.Actor)bin.readObj(false, null);
			map.put(key, value);
		}
		return map;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> map = (Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>)obj1;
		int n = map.size();
		bbuf.putLength(n);
		for (Map.Entry<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> obj : map.entrySet()) {
			bbuf.putInt(obj.getKey() != null ? (Integer)obj.getKey() : 0);
			bout.writeObj(obj.getValue(), false, null);
		}
	}
	
}