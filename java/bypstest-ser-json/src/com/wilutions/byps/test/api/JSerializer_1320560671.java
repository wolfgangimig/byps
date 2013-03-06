package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Set<java.lang.Double>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1320560671 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_1320560671();
	
	public JSerializer_1320560671() {
		super(1320560671);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final HashSet<java.lang.Double> arr = new HashSet<java.lang.Double>();
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.Double obj = bin.currentObject.getDouble(i0);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.Set<java.lang.Double> arr = (java.util.Set<java.lang.Double>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (java.lang.Double obj : arr) {
			bbuf.putDouble(obj != null ? (Double)obj : 0.0);
		}
		bbuf.endArray();
	}
	
}
