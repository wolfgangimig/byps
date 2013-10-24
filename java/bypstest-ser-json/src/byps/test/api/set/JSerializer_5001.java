package byps.test.api.set;

/*
 * Serializer for byps.test.api.set.SetTypes
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=13

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class JSerializer_5001 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_5001();
	
	public JSerializer_5001() {
		super(5001);
	}
	
	public JSerializer_5001(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final SetTypes obj = (SetTypes)obj1;		
		bout.writeObj("boolean1",obj.boolean1, false, byps.test.api.JSerializer_1365696060.instance);
		bout.writeObj("byte1",obj.byte1, false, byps.test.api.JSerializer_31512998.instance);
		bout.writeObj("byte2",obj.byte2, false, byps.test.api.JSerializer_2052431866.instance);
		bout.writeObj("char1",obj.char1, false, byps.test.api.JSerializer_936607009.instance);
		bout.writeObj("double1",obj.double1, false, byps.test.api.JSerializer_1320560671.instance);
		bout.writeObj("float1",obj.float1, false, byps.test.api.JSerializer_1898022288.instance);
		bout.writeObj("int1",obj.int1, false, byps.test.api.JSerializer_1493282670.instance);
		bout.writeObj("int2",obj.int2, false, byps.test.api.JSerializer_1406124761.instance);
		bout.writeObj("long1",obj.long1, false, byps.test.api.JSerializer_1457164460.instance);
		bout.writeObj("obj1",obj.obj1, false, byps.JSerializer_14.instance);
		bout.writeObj("primitiveTypes1",obj.primitiveTypes1, false, byps.test.api.JSerializer_673917574.instance);
		bout.writeObj("short1",obj.short1, false, byps.test.api.JSerializer_2028443792.instance);
		bout.writeObj("string1",obj.string1, false, byps.test.api.JSerializer_1888799711.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final SetTypes obj = (SetTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new SetTypes()));
		
		final BJsonObject js = bin.currentObject;
		obj.boolean1 = (java.util.Set<java.lang.Boolean>)bin.readObj("boolean1", false, byps.test.api.JSerializer_1365696060.instance);
		obj.byte1 = (java.util.HashSet<java.lang.Byte>)bin.readObj("byte1", false, byps.test.api.JSerializer_31512998.instance);
		obj.byte2 = (java.util.Set<byte[]>)bin.readObj("byte2", false, byps.test.api.JSerializer_2052431866.instance);
		obj.char1 = (java.util.TreeSet<java.lang.Character>)bin.readObj("char1", false, byps.test.api.JSerializer_936607009.instance);
		obj.double1 = (java.util.Set<java.lang.Double>)bin.readObj("double1", false, byps.test.api.JSerializer_1320560671.instance);
		obj.float1 = (java.util.Set<java.lang.Float>)bin.readObj("float1", false, byps.test.api.JSerializer_1898022288.instance);
		obj.int1 = (java.util.Set<java.lang.Integer>)bin.readObj("int1", false, byps.test.api.JSerializer_1493282670.instance);
		obj.int2 = (java.util.Set<int[]>)bin.readObj("int2", false, byps.test.api.JSerializer_1406124761.instance);
		obj.long1 = (java.util.Set<java.lang.Long>)bin.readObj("long1", false, byps.test.api.JSerializer_1457164460.instance);
		obj.obj1 = (java.util.Set<java.lang.Object>)bin.readObj("obj1", false, byps.JSerializer_14.instance);
		obj.primitiveTypes1 = (java.util.Set<byps.test.api.prim.PrimitiveTypes>)bin.readObj("primitiveTypes1", false, byps.test.api.JSerializer_673917574.instance);
		obj.short1 = (java.util.Set<java.lang.Short>)bin.readObj("short1", false, byps.test.api.JSerializer_2028443792.instance);
		obj.string1 = (java.util.Set<java.lang.String>)bin.readObj("string1", false, byps.test.api.JSerializer_1888799711.instance);
		
		return obj;
	}
	
}
