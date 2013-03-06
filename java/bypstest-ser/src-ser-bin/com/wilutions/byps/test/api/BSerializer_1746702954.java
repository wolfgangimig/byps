package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<java.util.List<java.lang.Integer>>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1746702954 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1746702954();
	
	public BSerializer_1746702954() {
		super(1746702954);
	}
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final ArrayList<List<java.lang.Integer>> arr = new ArrayList<List<java.lang.Integer>>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.util.List<java.lang.Integer> obj = (java.util.List<java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.List<java.util.List<java.lang.Integer>> arr = (java.util.List<java.util.List<java.lang.Integer>>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (java.util.List<java.lang.Integer> obj : arr) {
			bout.writeObj(obj, false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
		}
	}
	
}
