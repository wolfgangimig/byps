﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Set<byte[]>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_2052431866 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_2052431866();
	
	public BSerializer_2052431866() {
		super(2052431866);
	}
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final HashSet<byte[]> arr = new HashSet<byte[]>();
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
		java.util.Set<byte[]> arr = (java.util.Set<byte[]>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (byte[] obj : arr) {
			bout.writeObj(obj, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
		}
	}
	
}