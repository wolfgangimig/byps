package com.wilutions.byps.test.servlet;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;
import com.wilutions.byps.test.api.remote.BSkeleton_RemotePrimitiveTypes;

public class MyRemotePrimitiveTypes extends BSkeleton_RemotePrimitiveTypes {
	
	public boolean boolVal;
	public byte byteVal;
	public char charVal;
	public short shortVal;
	public int intVal;
	public long longVal;
	public float floatVal;
	public double doubleVal;
	public String stringVal;
	public Object objectVal;
	public PrimitiveTypes primitiveTypesVal;

	public void setBool(boolean v) throws BException, InterruptedException {
		this.boolVal = v;
	}
	
	public boolean getBool() throws BException, InterruptedException {
		return this.boolVal;
	}
	
	@Override
	public void setByte(byte v) throws BException, InterruptedException {
		this.byteVal = v;
	}
	
	@Override
	public byte getByte() throws BException, InterruptedException {
		return byteVal;
	}
	
	@Override
	public void setChar(char v) throws BException, InterruptedException {
		charVal = v;
	}
	
	@Override
	public char getChar() throws BException, InterruptedException {
		return charVal;
	}
	
	@Override
	public void setShort(short v) throws BException, InterruptedException {
		shortVal = v;
	}
	
	@Override
	public short getShort() throws BException, InterruptedException {
		return shortVal;
	}
	
	@Override
	public void setInt(int v) throws BException, InterruptedException {
		intVal = v;
	}
	
	@Override
	public int getInt() throws BException, InterruptedException {
		return intVal;
	}
	
	@Override
	public void setLong(long v) throws BException, InterruptedException {
		longVal = v;
	}
	
	@Override
	public long getLong() throws BException, InterruptedException {
		return longVal;
	}
	
	@Override
	public void setFloat(float v) throws BException, InterruptedException {
		floatVal = v;
	}
	
	@Override
	public float getFloat() throws BException, InterruptedException {
		return floatVal;
	}

	@Override
	public void setDouble(double v) throws BException, InterruptedException {
		doubleVal = v;
	}
	
	@Override
	public double getDouble() throws BException, InterruptedException {
		return doubleVal;
	}
	
	@Override
	public void setString(String v) throws BException, InterruptedException {
		stringVal = v;
	}
	
	@Override
	public String getString() throws BException, InterruptedException {
		return stringVal;
	}
	
	@Override
	public void setObject(Object v) throws BException, InterruptedException {
		objectVal = v;
	}
	
	@Override
	public Object getObject() throws BException, InterruptedException {
		return objectVal;
	}
	
	@Override
	public void setPrimitiveTypes(PrimitiveTypes v) throws BException, InterruptedException {
		primitiveTypesVal = v;
	}
	
	@Override
	public PrimitiveTypes getPrimitiveTypes() throws BException, InterruptedException {
		return primitiveTypesVal;
	}
	
	@Override
	public void sendAllTypes(boolean b, char c, short s, int i, long l,
			float f, double d, String str, PrimitiveTypes pt, Object o)
			throws BException, InterruptedException {
		this.boolVal = b;
		this.charVal  =c;
		this.doubleVal = d;
		this.floatVal = f;
		this.intVal = i;
		this.longVal = l;
		this.shortVal = s;
		this.stringVal = str;
		this.objectVal = o;
		this.primitiveTypesVal = pt;
	}
	
	
}
