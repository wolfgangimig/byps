﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DArray1dim
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
public class JSerializer_531757758 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_531757758();
	
	
	public JSerializer_531757758() {
		super(531757758);
	}
	
	public JSerializer_531757758(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteInlineInstance_setPoint2DArray1dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray1dim)obj1;		
		bout.writeObj("pointArray",obj.pointArray, false, com.wilutions.byps.test.api.JSerializer_2049740106.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_setPoint2DArray1dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DArray1dim()));
		
		final BJsonObject js = bin.currentObject;
		obj.pointArray = (com.wilutions.byps.test.api.inl.Point2D[])bin.readObj("pointArray", false, com.wilutions.byps.test.api.JSerializer_2049740106.instance);
		
		return obj;
	}
	
}