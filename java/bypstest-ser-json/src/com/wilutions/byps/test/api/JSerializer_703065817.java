﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_703065817 extends JSerializer_13 {
	
	public final static BSerializer instance = new JSerializer_703065817();
	
	public JSerializer_703065817() {
		super(703065817);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BJsonObject js = bin.currentObject;
		final Set<String> keys = js.keys();
		final HashMap<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes> map = new HashMap<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>(keys.size());
		bin.onObjectCreated(map);
		for (String keyName : keys) {
			java.lang.Integer key = keyName != null && keyName.length() != 0 ? Integer.parseInt(keyName) : 0;
			final com.wilutions.byps.test.api.prim.PrimitiveTypes value = (com.wilutions.byps.test.api.prim.PrimitiveTypes)bin.readObj(keyName, false, null);
			map.put(key, value);
		}
		return map;
	}
	
	@Override
	protected void internalWriteKeyValue(final BOutputJson bout, final BBufferJson bbuf, final Object key, final Object value) throws BException {
		final String keyName = key != null ? key.toString() : "";
		bout.writeObj(keyName, value, false, null);
	}
	
}