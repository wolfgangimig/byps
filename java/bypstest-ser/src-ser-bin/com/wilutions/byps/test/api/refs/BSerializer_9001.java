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
public class BSerializer_9001 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_9001();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: next */ + 4		
		       /* pos=4: me */ + 4		
		       /* pos=8: mapOfNodes */ + 4		
		       /* pos=12: listOfNodes */ + 4		
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_9001() {
		super(9001);
	}
	
	public BSerializer_9001(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final Node obj = (Node)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.listOfNodes, false, com.wilutions.byps.test.api.BSerializer_202657921.instance);
		bout.writeObj(obj.mapOfNodes, false, com.wilutions.byps.test.api.BSerializer_1768677016.instance);
		bout.writeObj(obj.me, false, null);
		bout.writeObj(obj.next, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final Node obj = (Node)(obj1 != null ? obj1 : bin.onObjectCreated(new Node()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.listOfNodes = (java.util.List<com.wilutions.byps.test.api.refs.Node>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_202657921.instance);
		obj.mapOfNodes = (java.util.Map<java.lang.String,com.wilutions.byps.test.api.refs.Node>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1768677016.instance);
		obj.me = (com.wilutions.byps.test.api.refs.Node)bin.readObj(false, null);
		obj.next = (com.wilutions.byps.test.api.refs.Node)bin.readObj(false, null);
		
		return obj;
	}
	
}
