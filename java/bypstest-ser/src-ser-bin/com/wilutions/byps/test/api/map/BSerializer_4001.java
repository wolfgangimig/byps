﻿package com.wilutions.byps.test.api.map;

/*
 * Serializer for com.wilutions.byps.test.api.map.MapTypes
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=13

@SuppressWarnings("all")
public class BSerializer_4001 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_4001();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: boolean1 */ + 4		
		       /* pos=4: byte1 */ + 4		
		       /* pos=8: char1 */ + 4		
		       /* pos=12: short1 */ + 4		
		       /* pos=16: int1 */ + 4		
		       /* pos=20: long1 */ + 4		
		       /* pos=24: float1 */ + 4		
		       /* pos=28: double1 */ + 4		
		       /* pos=32: string1 */ + 4		
		       /* pos=36: primitiveTypes1 */ + 4		
		       /* pos=40: byte2 */ + 4		
		       /* pos=44: int2 */ + 4		
		       /* pos=48: obj1 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_4001() {
		super(4001);
	}
	
	public BSerializer_4001(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final MapTypes obj = (MapTypes)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.boolean1, false, com.wilutions.byps.test.api.BSerializer_1279823631.instance);
		bout.writeObj(obj.byte1, false, com.wilutions.byps.test.api.BSerializer_1972793385.instance);
		bout.writeObj(obj.byte2, false, com.wilutions.byps.test.api.BSerializer_1799280818.instance);
		bout.writeObj(obj.char1, false, com.wilutions.byps.test.api.BSerializer_8789515.instance);
		bout.writeObj(obj.double1, false, com.wilutions.byps.test.api.BSerializer_1487265161.instance);
		bout.writeObj(obj.float1, false, com.wilutions.byps.test.api.BSerializer_94341197.instance);
		bout.writeObj(obj.int1, false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
		bout.writeObj(obj.int2, false, com.wilutions.byps.test.api.BSerializer_1633750383.instance);
		bout.writeObj(obj.long1, false, com.wilutions.byps.test.api.BSerializer_1973996106.instance);
		bout.writeObj(obj.obj1, false, com.wilutions.byps.test.api.BSerializer_1488550492.instance);
		bout.writeObj(obj.primitiveTypes1, false, com.wilutions.byps.test.api.BSerializer_703065817.instance);
		bout.writeObj(obj.short1, false, com.wilutions.byps.test.api.BSerializer_601099730.instance);
		bout.writeObj(obj.string1, false, com.wilutions.byps.test.api.BSerializer_1710660846.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final MapTypes obj = (MapTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new MapTypes()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.boolean1 = (java.util.Map<java.lang.String,java.lang.Boolean>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1279823631.instance);
		obj.byte1 = (java.util.HashMap<java.lang.Double,java.lang.Byte>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1972793385.instance);
		obj.byte2 = (java.util.Map<java.lang.Integer,byte[]>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1799280818.instance);
		obj.char1 = (java.util.TreeMap<java.lang.Float,java.lang.Character>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_8789515.instance);
		obj.double1 = (java.util.Map<java.lang.Byte,java.lang.Double>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1487265161.instance);
		obj.float1 = (java.util.Map<java.lang.Character,java.lang.Float>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_94341197.instance);
		obj.int1 = (java.util.Map<java.lang.Integer,java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
		obj.int2 = (java.util.Map<java.lang.Integer,int[]>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1633750383.instance);
		obj.long1 = (java.util.Map<java.lang.Short,java.lang.Long>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1973996106.instance);
		obj.obj1 = (java.util.Map<java.lang.String,java.lang.Object>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1488550492.instance);
		obj.primitiveTypes1 = (java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_703065817.instance);
		obj.short1 = (java.util.Map<java.lang.Long,java.lang.Short>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_601099730.instance);
		obj.string1 = (java.util.Map<java.lang.String,java.lang.String>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1710660846.instance);
		
		return obj;
	}
	
}