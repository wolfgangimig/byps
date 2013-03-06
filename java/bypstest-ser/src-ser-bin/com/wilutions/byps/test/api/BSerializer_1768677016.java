package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.String,com.wilutions.byps.test.api.refs.Node>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class BSerializer_1768677016 extends BSerializer_13 {
	
	public final static BSerializer instance = new BSerializer_1768677016();
	
	public BSerializer_1768677016() {
		super(1768677016);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BBufferBin bbuf = bin.bbuf;
		final HashMap<java.lang.String,com.wilutions.byps.test.api.refs.Node> map = new HashMap<java.lang.String,com.wilutions.byps.test.api.refs.Node>();
		bin.onObjectCreated(map);
		int n = bbuf.getLength();
		for (int i0 = 0; i0 < n; i0++) {
			java.lang.String key = bbuf.getString();
			com.wilutions.byps.test.api.refs.Node value = (com.wilutions.byps.test.api.refs.Node)bin.readObj(false, null);
			map.put(key, value);
		}
		return map;
	}
	
	public void write(Object obj1, BOutput bout1, int version)  throws BException {
		BOutputBin bout = (BOutputBin)bout1;
		BBufferBin bbuf = bout.bbuf;
		Map<java.lang.String,com.wilutions.byps.test.api.refs.Node> map = (Map<java.lang.String,com.wilutions.byps.test.api.refs.Node>)obj1;
		int n = map.size();
		bbuf.putLength(n);
		for (Map.Entry<java.lang.String,com.wilutions.byps.test.api.refs.Node> obj : map.entrySet()) {
			bbuf.putString(obj.getKey() != null ? (String)obj.getKey() : "");
			bout.writeObj(obj.getValue(), false, null);
		}
	}
	
}
