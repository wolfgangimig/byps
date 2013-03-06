package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<com.wilutions.byps.test.api.inl.Actor>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_494001343 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_494001343();
	
	public BSerializer_494001343() {
		super(494001343);
	}
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final ArrayList<com.wilutions.byps.test.api.inl.Actor> arr = new ArrayList<com.wilutions.byps.test.api.inl.Actor>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			com.wilutions.byps.test.api.inl.Actor obj = (com.wilutions.byps.test.api.inl.Actor)bin.readObj(false, null);
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.List<com.wilutions.byps.test.api.inl.Actor> arr = (java.util.List<com.wilutions.byps.test.api.inl.Actor>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (com.wilutions.byps.test.api.inl.Actor obj : arr) {
			bout.writeObj(obj, false, null);
		}
	}
	
}
