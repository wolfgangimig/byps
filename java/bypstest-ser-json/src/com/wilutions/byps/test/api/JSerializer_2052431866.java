﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Set<byte[]>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_2052431866 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_2052431866();
	
	public JSerializer_2052431866() {
		super(2052431866);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final HashSet<byte[]> arr = new HashSet<byte[]>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			byte[] obj = bin.currentObject.getArrayByte(i0);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.Set<byte[]> arr = (java.util.Set<byte[]>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (byte[] obj : arr) {
			bbuf.putArrayByte((byte[])obj);
		}
		bbuf.endArray();
	}
	
}