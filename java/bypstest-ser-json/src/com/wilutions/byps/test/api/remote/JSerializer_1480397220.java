package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteReferences_getNode
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
public class JSerializer_1480397220 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1480397220();
	
	
	public JSerializer_1480397220() {
		super(1480397220);
	}
	
	public JSerializer_1480397220(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteReferences_getNode obj = (BResult_RemoteReferences_getNode)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteReferences_getNode obj = (BResult_RemoteReferences_getNode)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteReferences_getNode()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.refs.Node)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
