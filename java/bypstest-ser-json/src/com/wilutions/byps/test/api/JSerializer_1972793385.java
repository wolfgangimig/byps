﻿package com.wilutions.byps.test.api;

/*
 * Serializer for java.util.HashMap<java.lang.Double,java.lang.Byte>
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1972793385 extends JSerializer_13 {
	
	public final static BSerializer instance = new JSerializer_1972793385();
	
	public JSerializer_1972793385() {
		super(1972793385);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BJsonObject js = bin.currentObject;
		final Set<String> keys = js.keys();
		final HashMap<java.lang.Double,java.lang.Byte> map = new HashMap<java.lang.Double,java.lang.Byte>(keys.size());
		bin.onObjectCreated(map);
		for (String keyName : keys) {
			java.lang.Double key = keyName != null && keyName.length() != 0 ? Double.parseDouble(keyName) : 0.0;
			final java.lang.Byte value = js.getByte(keyName);
			map.put(key, value);
		}
		return map;
	}
	
	@Override
	protected void internalWriteKeyValue(final BOutputJson bout, final BBufferJson bbuf, final Object key, final Object value) throws BException {
		final String keyName = key != null ? key.toString() : "";
		bbuf.putByte(keyName, value != null ? (Byte)value : ((byte)0));
	}
	
}