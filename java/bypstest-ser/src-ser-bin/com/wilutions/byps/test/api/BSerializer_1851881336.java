package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1851881336 extends BSerializer_13 {
	
	public final static BSerializer instance = new BSerializer_1851881336();
	
	public BSerializer_1851881336() {
		super(1851881336);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final HashMap<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D> map = new HashMap<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>();
		bin.onObjectCreated(map);
		int n = bbuf.getLength();
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Integer key = bbuf.getInt();
			com.wilutions.byps.test.api.inl.Point2D value = (com.wilutions.byps.test.api.inl.Point2D)bin.readObj(false, com.wilutions.byps.test.api.inl.BSerializer_1835035436.instance);
			map.put(key, value);
		}
		return map;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D> map = (Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>)obj1;
		int n = map.size();
		bbuf.putLength(n);
		for (Map.Entry<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D> obj : map.entrySet()) {
			bbuf.putInt(obj.getKey() != null ? (Integer)obj.getKey() : 0);
			bout.writeObj(obj.getValue(), false, com.wilutions.byps.test.api.inl.BSerializer_1835035436.instance);
		}
	}
	
}
