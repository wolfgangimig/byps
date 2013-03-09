﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<byte[]>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1174971318 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1174971318();
	
	public BSerializer_1174971318() {
		super(1174971318);
	}
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final ArrayList<byte[]> arr = new ArrayList<byte[]>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			byte[] obj = (byte[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.List<byte[]> arr = (java.util.List<byte[]>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (byte[] obj : arr) {
			bout.writeObj(obj, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
		}
	}
	
}