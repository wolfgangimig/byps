package com.wilutions.byps.test.api.refs;

/*
 * Serializer for com.wilutions.byps.test.api.refs.Node
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=4

@SuppressWarnings("all")
public class JSerializer_9001 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_9001();
	
	
	public JSerializer_9001() {
		super(9001);
	}
	
	public JSerializer_9001(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final Node obj = (Node)obj1;		
		bout.writeObj("listOfNodes",obj.listOfNodes, false, com.wilutions.byps.test.api.JSerializer_202657921.instance);
		bout.writeObj("mapOfNodes",obj.mapOfNodes, false, com.wilutions.byps.test.api.JSerializer_1768677016.instance);
		bout.writeObj("me",obj.me, false, null);
		bout.writeObj("next",obj.next, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final Node obj = (Node)(obj1 != null ? obj1 : bin.onObjectCreated(new Node()));
		
		final BJsonObject js = bin.currentObject;
		obj.listOfNodes = (java.util.List<com.wilutions.byps.test.api.refs.Node>)bin.readObj("listOfNodes", false, com.wilutions.byps.test.api.JSerializer_202657921.instance);
		obj.mapOfNodes = (java.util.Map<java.lang.String,com.wilutions.byps.test.api.refs.Node>)bin.readObj("mapOfNodes", false, com.wilutions.byps.test.api.JSerializer_1768677016.instance);
		obj.me = (com.wilutions.byps.test.api.refs.Node)bin.readObj("me", false, null);
		obj.next = (com.wilutions.byps.test.api.refs.Node)bin.readObj("next", false, null);
		
		return obj;
	}
	
}
