package byps.test.api.set;

/*
 * Serializer for byps.test.api.set.SetTypes
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=13

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class BSerializer_5001 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_5001();
	
	public BSerializer_5001() {
		super(5001);
	}
	
	public BSerializer_5001(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final SetTypes obj = (SetTypes)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.boolean1, false, byps.test.api.BSerializer_1365696060.instance);
		bout.writeObj(obj.byte1, false, byps.test.api.BSerializer_31512998.instance);
		bout.writeObj(obj.byte2, false, byps.test.api.BSerializer_2052431866.instance);
		bout.writeObj(obj.char1, false, byps.test.api.BSerializer_936607009.instance);
		bout.writeObj(obj.double1, false, byps.test.api.BSerializer_1320560671.instance);
		bout.writeObj(obj.float1, false, byps.test.api.BSerializer_1898022288.instance);
		bout.writeObj(obj.int1, false, byps.test.api.BSerializer_1493282670.instance);
		bout.writeObj(obj.int2, false, byps.test.api.BSerializer_1406124761.instance);
		bout.writeObj(obj.long1, false, byps.test.api.BSerializer_1457164460.instance);
		bout.writeObj(obj.obj1, false, byps.BSerializer_14.instance);
		bout.writeObj(obj.primitiveTypes1, false, byps.test.api.BSerializer_673917574.instance);
		bout.writeObj(obj.short1, false, byps.test.api.BSerializer_2028443792.instance);
		bout.writeObj(obj.string1, false, byps.test.api.BSerializer_1888799711.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final SetTypes obj = (SetTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new SetTypes()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.boolean1 = (java.util.Set<java.lang.Boolean>)bin.readObj(false, byps.test.api.BSerializer_1365696060.instance);
		obj.byte1 = (java.util.HashSet<java.lang.Byte>)bin.readObj(false, byps.test.api.BSerializer_31512998.instance);
		obj.byte2 = (java.util.Set<byte[]>)bin.readObj(false, byps.test.api.BSerializer_2052431866.instance);
		obj.char1 = (java.util.TreeSet<java.lang.Character>)bin.readObj(false, byps.test.api.BSerializer_936607009.instance);
		obj.double1 = (java.util.Set<java.lang.Double>)bin.readObj(false, byps.test.api.BSerializer_1320560671.instance);
		obj.float1 = (java.util.Set<java.lang.Float>)bin.readObj(false, byps.test.api.BSerializer_1898022288.instance);
		obj.int1 = (java.util.Set<java.lang.Integer>)bin.readObj(false, byps.test.api.BSerializer_1493282670.instance);
		obj.int2 = (java.util.Set<int[]>)bin.readObj(false, byps.test.api.BSerializer_1406124761.instance);
		obj.long1 = (java.util.Set<java.lang.Long>)bin.readObj(false, byps.test.api.BSerializer_1457164460.instance);
		obj.obj1 = (java.util.Set<java.lang.Object>)bin.readObj(false, byps.BSerializer_14.instance);
		obj.primitiveTypes1 = (java.util.Set<byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, byps.test.api.BSerializer_673917574.instance);
		obj.short1 = (java.util.Set<java.lang.Short>)bin.readObj(false, byps.test.api.BSerializer_2028443792.instance);
		obj.string1 = (java.util.Set<java.lang.String>)bin.readObj(false, byps.test.api.BSerializer_1888799711.instance);
		
		return obj;
	}
	
}
