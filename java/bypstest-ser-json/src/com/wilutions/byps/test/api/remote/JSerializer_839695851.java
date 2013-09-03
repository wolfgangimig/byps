﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteWithAuthentication_login
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=3

@SuppressWarnings("all")
public class JSerializer_839695851 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_839695851();
	
	
	public JSerializer_839695851() {
		super(839695851);
	}
	
	public JSerializer_839695851(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteWithAuthentication_login obj = (BRequest_RemoteWithAuthentication_login)obj1;		
		bbuf.putString("userName", obj.userName);
		bbuf.putString("userPwd", obj.userPwd);
		bout.writeObj("sess",obj.sess, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteWithAuthentication_login obj = (BRequest_RemoteWithAuthentication_login)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteWithAuthentication_login()));
		
		final BJsonObject js = bin.currentObject;
		obj.userName = js.getString("userName");
		obj.userPwd = js.getString("userPwd");
		obj.sess = (com.wilutions.byps.test.api.auth.SessionInfo)bin.readObj("sess", false, null);
		
		return obj;
	}
	
}