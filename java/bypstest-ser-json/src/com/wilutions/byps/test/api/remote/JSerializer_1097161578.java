﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DListList
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class JSerializer_1097161578 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1097161578();
	
	
	public JSerializer_1097161578() {
		super(1097161578);
	}
	
	public JSerializer_1097161578(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteInlineInstance_setPoint2DListList obj = (BRequest_RemoteInlineInstance_setPoint2DListList)obj1;		
		bout.writeObj("pointListList",obj.pointListList, false, com.wilutions.byps.test.api.JSerializer_1463615848.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_setPoint2DListList obj = (BRequest_RemoteInlineInstance_setPoint2DListList)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DListList()));
		
		final BJsonObject js = bin.currentObject;
		obj.pointListList = (java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>>)bin.readObj("pointListList", false, com.wilutions.byps.test.api.JSerializer_1463615848.instance);
		
		return obj;
	}
	
}