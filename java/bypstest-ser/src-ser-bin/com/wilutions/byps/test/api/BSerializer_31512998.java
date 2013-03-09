﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.HashSet<java.lang.Byte>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_31512998 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_31512998();
	
	public BSerializer_31512998() {
		super(31512998);
	}
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final HashSet<java.lang.Byte> arr = new HashSet<java.lang.Byte>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Byte obj = bbuf.getByte();
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.HashSet<java.lang.Byte> arr = (java.util.HashSet<java.lang.Byte>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (java.lang.Byte obj : arr) {
			bbuf.putByte(obj != null ? (Byte)obj : ((byte)0));
		}
	}
	
}