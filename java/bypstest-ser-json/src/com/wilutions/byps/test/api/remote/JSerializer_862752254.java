package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteConstants_compare_AllTypesC
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=17

@SuppressWarnings("all")
public class JSerializer_862752254 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_862752254();
	
	
	public JSerializer_862752254() {
		super(862752254);
	}
	
	public JSerializer_862752254(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteConstants_compare_AllTypesC obj = (BRequest_RemoteConstants_compare_AllTypesC)obj1;		
		bbuf.putBoolean("bool1s", obj.bool1s);
		bbuf.putBoolean("bool2s", obj.bool2s);
		bbuf.putChar("char1s", obj.char1s);
		bbuf.putChar("char2s", obj.char2s);
		bbuf.putDouble("double1s", obj.double1s);
		bbuf.putFloat("float1s", obj.float1s);
		bbuf.putInt("int1s", obj.int1s);
		bbuf.putLong("long1s", obj.long1s);
		bbuf.putShort("short1s", obj.short1s);
		bbuf.putString("string1s", obj.string1s);
		bbuf.putString("stringNull", obj.stringNull);
		bout.writeObj("ALL",obj.ALL, false, null);
		bout.writeObj("arrAll",obj.arrAll, false, com.wilutions.byps.test.api.JSerializer_1981543076.instance);
		bout.writeObj("arrInt",obj.arrInt, false, com.wilutions.byps.test.api.JSerializer_100361105.instance);
		bout.writeObj("arrInt4",obj.arrInt4, false, com.wilutions.byps.test.api.JSerializer_39910537.instance);
		bout.writeObj("arrStrings",obj.arrStrings, true, com.wilutions.byps.test.api.JSerializer_1888107655.instance);
		bout.writeObj("arrStrings4",obj.arrStrings4, true, com.wilutions.byps.test.api.JSerializer_588723219.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteConstants_compare_AllTypesC obj = (BRequest_RemoteConstants_compare_AllTypesC)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteConstants_compare_AllTypesC()));
		
		final BJsonObject js = bin.currentObject;
		obj.bool1s = js.getBoolean("bool1s");
		obj.bool2s = js.getBoolean("bool2s");
		obj.char1s = js.getChar("char1s");
		obj.char2s = js.getChar("char2s");
		obj.double1s = js.getDouble("double1s");
		obj.float1s = js.getFloat("float1s");
		obj.int1s = js.getInt("int1s");
		obj.long1s = js.getLong("long1s");
		obj.short1s = js.getShort("short1s");
		obj.string1s = js.getString("string1s");
		obj.stringNull = js.getString("stringNull");
		obj.ALL = (com.wilutions.byps.test.api.cons.AllTypesZ)bin.readObj("ALL", false, null);
		obj.arrAll = (com.wilutions.byps.test.api.cons.AllTypesZ[][])bin.readObj("arrAll", false, com.wilutions.byps.test.api.JSerializer_1981543076.instance);
		obj.arrInt = (int[])bin.readObj("arrInt", false, com.wilutions.byps.test.api.JSerializer_100361105.instance);
		obj.arrInt4 = (int[][][][])bin.readObj("arrInt4", false, com.wilutions.byps.test.api.JSerializer_39910537.instance);
		obj.arrStrings = (java.lang.String[])bin.readObj("arrStrings", true, com.wilutions.byps.test.api.JSerializer_1888107655.instance);
		obj.arrStrings4 = (java.lang.String[][][][])bin.readObj("arrStrings4", true, com.wilutions.byps.test.api.JSerializer_588723219.instance);
		
		return obj;
	}
	
}
