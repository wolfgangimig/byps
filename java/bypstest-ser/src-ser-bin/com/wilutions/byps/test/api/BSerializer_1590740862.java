﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1590740862 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1590740862();
	
	public BSerializer_1590740862() {
		super(1590740862);
	}
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final int n = bbuf.getLength();
		final ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets> arr = new ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			com.wilutions.byps.test.api.enu.EnumPlanets obj = BEnumHelper.fromOrdinal(com.wilutions.byps.test.api.enu.EnumPlanets.values(), bbuf.getInt());
			arr.add(obj);
		}
		return arr;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets> arr = (java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>)obj1;
		int n = arr.size();
		bbuf.putLength(n);
		for (com.wilutions.byps.test.api.enu.EnumPlanets obj : arr) {
			bbuf.putInt(obj != null ? ((com.wilutions.byps.test.api.enu.EnumPlanets)obj).ordinal() : 0);
		}
	}
	
}