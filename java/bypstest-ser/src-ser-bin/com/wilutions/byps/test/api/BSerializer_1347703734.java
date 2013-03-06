package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.Integer,java.lang.Integer>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1347703734 extends BSerializer_13 {
	
	public final static BSerializer instance = new BSerializer_1347703734();
	
	public BSerializer_1347703734() {
		super(1347703734);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final HashMap<java.lang.Integer,java.lang.Integer> map = new HashMap<java.lang.Integer,java.lang.Integer>();
		bin.onObjectCreated(map);
		int n = bbuf.getLength();
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Integer key = bbuf.getInt();
			java.lang.Integer value = bbuf.getInt();
			map.put(key, value);
		}
		return map;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		Map<java.lang.Integer,java.lang.Integer> map = (Map<java.lang.Integer,java.lang.Integer>)obj1;
		int n = map.size();
		bbuf.putLength(n);
		for (Map.Entry<java.lang.Integer,java.lang.Integer> obj : map.entrySet()) {
			bbuf.putInt(obj.getKey() != null ? (Integer)obj.getKey() : 0);
			bbuf.putInt(obj.getValue() != null ? (Integer)obj.getValue() : 0);
		}
	}
	
}
