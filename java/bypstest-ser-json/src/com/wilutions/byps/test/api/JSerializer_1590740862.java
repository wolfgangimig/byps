package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1590740862 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_1590740862();
	
	public JSerializer_1590740862() {
		super(1590740862);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets> arr = new ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			com.wilutions.byps.test.api.enu.EnumPlanets obj = BEnumHelper.fromOrdinal(com.wilutions.byps.test.api.enu.EnumPlanets.values(), bin.currentObject.getInt(i0));
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets> arr = (java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (com.wilutions.byps.test.api.enu.EnumPlanets obj : arr) {
			bbuf.putInt(obj != null ? ((com.wilutions.byps.test.api.enu.EnumPlanets)obj).ordinal() : 0);
		}
		bbuf.endArray();
	}
	
}
