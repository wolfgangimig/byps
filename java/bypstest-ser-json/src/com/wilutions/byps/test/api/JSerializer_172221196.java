package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<com.wilutions.byps.test.api.inl.Point2D>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_172221196 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_172221196();
	
	public JSerializer_172221196() {
		super(172221196);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<com.wilutions.byps.test.api.inl.Point2D> arr = new ArrayList<com.wilutions.byps.test.api.inl.Point2D>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			com.wilutions.byps.test.api.inl.Point2D obj = (com.wilutions.byps.test.api.inl.Point2D)bin.readObj(i0, false, com.wilutions.byps.test.api.inl.JSerializer_1835035436.instance);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.List<com.wilutions.byps.test.api.inl.Point2D> arr = (java.util.List<com.wilutions.byps.test.api.inl.Point2D>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (com.wilutions.byps.test.api.inl.Point2D obj : arr) {
			bout.writeObj(null, obj, false, com.wilutions.byps.test.api.inl.JSerializer_1835035436.instance);
		}
		bbuf.endArray();
	}
	
}
