﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<java.lang.String>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_2123584667 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_2123584667();
	
	public BSerializer_2123584667() {
		super(2123584667);
	}
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final ArrayList<java.lang.String> arr = new ArrayList<java.lang.String>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.String obj = bbuf.getString();
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.List<java.lang.String> arr = (java.util.List<java.lang.String>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (java.lang.String obj : arr) {
			bbuf.putString(obj != null ? (String)obj : "");
		}
	}
	
}