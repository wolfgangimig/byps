﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.String,java.lang.String>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1710660846 extends JSerializer_13 {
	
	public final static BSerializer instance = new JSerializer_1710660846();
	
	public JSerializer_1710660846() {
		super(1710660846);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BJsonObject js = bin.currentObject;
		final Set<String> keys = js.keys();
		final HashMap<java.lang.String,java.lang.String> map = new HashMap<java.lang.String,java.lang.String>(keys.size());
		bin.onObjectCreated(map);
		for (String keyName : keys) {
			java.lang.String key = keyName;
			final java.lang.String value = js.getString(keyName);
			map.put(key, value);
		}
		return map;
	}
	
	@Override
	protected void internalWriteKeyValue(final BOutputJson bout, final BBufferJson bbuf, final Object key, final Object value) throws BException {
		final String keyName = key != null ? (String)key : "";
		bbuf.putString(keyName, value != null ? (String)value : "");
	}
	
}