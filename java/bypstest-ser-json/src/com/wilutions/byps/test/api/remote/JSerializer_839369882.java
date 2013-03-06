package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteEnums_getPlanet
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
public class JSerializer_839369882 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_839369882();
	
	
	public JSerializer_839369882() {
		super(839369882);
	}
	
	public JSerializer_839369882(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteEnums_getPlanet obj = (BResult_RemoteEnums_getPlanet)obj1;		
		bbuf.putInt("result", obj.result!=null ? obj.result.ordinal() : 0);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteEnums_getPlanet obj = (BResult_RemoteEnums_getPlanet)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteEnums_getPlanet()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = BEnumHelper.fromOrdinal(com.wilutions.byps.test.api.enu.EnumPlanets.values(), js.getInt("result"));
		
		return obj;
	}
	
}
