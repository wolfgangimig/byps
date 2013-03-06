package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.List<int[][][][]>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1088217157 extends BSerializer {
	
	public final static BSerializer instance = new JSerializer_1088217157();
	
	public JSerializer_1088217157() {
		super(1088217157);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BBufferJson bbuf = bin.bbuf;
		final int n = bin.currentObject.size();
		final ArrayList<int[][][][]> arr = new ArrayList<int[][][][]>(n);
		bin.onObjectCreated(arr);
		for (int i0 = 0; i0 < n; i0++) {
			int[][][][] obj = (int[][][][])bin.readObj(i0, false, com.wilutions.byps.test.api.JSerializer_39910537.instance);
			arr.add(obj);
		}
		return arr;
	}
	
	@Override
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputJson bout = (BOutputJson)bout1;
		BBufferJson bbuf = bout.bbuf;
		java.util.List<int[][][][]> arr = (java.util.List<int[][][][]>)obj1;
		int n = arr.size();
		bbuf.beginArray();
		for (int[][][][] obj : arr) {
			bout.writeObj(null, obj, false, com.wilutions.byps.test.api.JSerializer_39910537.instance);
		}
		bbuf.endArray();
	}
	
}
