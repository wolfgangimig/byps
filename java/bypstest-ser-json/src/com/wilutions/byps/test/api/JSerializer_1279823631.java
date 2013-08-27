﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.String,java.lang.Boolean>
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerMapJson DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1279823631 extends JSerializer_13 {
	
	public final static BSerializer instance = new JSerializer_1279823631();
	
	public JSerializer_1279823631() {
		super(1279823631);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BJsonObject js = bin.currentObject;
		final Set<String> keys = js.keys();
		final HashMap<java.lang.String,java.lang.Boolean> map = new HashMap<java.lang.String,java.lang.Boolean>(keys.size());
		bin.onObjectCreated(map);
		for (String keyName : keys) {
			java.lang.String key = keyName;
			final java.lang.Boolean value = js.getBoolean(keyName);
			map.put(key, value);
		}
		return map;
	}
	
	@Override
	protected void internalWriteKeyValue(final BOutputJson bout, final BBufferJson bbuf, final Object key, final Object value) throws BException {
		final String keyName = key != null ? (String)key : "";
		bbuf.putBoolean(keyName, value != null ? (Boolean)value : false);
	}
	
}
