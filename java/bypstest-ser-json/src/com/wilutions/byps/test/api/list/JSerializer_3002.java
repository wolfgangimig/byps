﻿package com.wilutions.byps.test.api.list;

/*
 * Serializer for com.wilutions.byps.test.api.list.ListListTypes
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=3

@SuppressWarnings("all")
public class JSerializer_3002 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_3002();
	
	
	public JSerializer_3002() {
		super(3002);
	}
	
	public JSerializer_3002(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final ListListTypes obj = (ListListTypes)obj1;		
		bout.writeObj("int2",obj.int2, false, com.wilutions.byps.test.api.JSerializer_1746702954.instance);
		bout.writeObj("int24",obj.int24, false, com.wilutions.byps.test.api.JSerializer_1865834185.instance);
		bout.writeObj("int3",obj.int3, false, com.wilutions.byps.test.api.JSerializer_1633500852.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final ListListTypes obj = (ListListTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new ListListTypes()));
		
		final BJsonObject js = bin.currentObject;
		obj.int2 = (java.util.List<java.util.List<java.lang.Integer>>)bin.readObj("int2", false, com.wilutions.byps.test.api.JSerializer_1746702954.instance);
		obj.int24 = (java.util.List<java.util.List<int[][][][]>>)bin.readObj("int24", false, com.wilutions.byps.test.api.JSerializer_1865834185.instance);
		obj.int3 = (java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>)bin.readObj("int3", false, com.wilutions.byps.test.api.JSerializer_1633500852.instance);
		
		return obj;
	}
	
}