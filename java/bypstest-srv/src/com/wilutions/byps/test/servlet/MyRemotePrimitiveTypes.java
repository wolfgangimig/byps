package com.wilutions.byps.test.servlet;

import com.wilutions.byps.RemoteException;
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

	public void setBool(boolean v) throws RemoteException {
		this.boolVal = v;
	}
	
	public boolean getBool() throws RemoteException {
		return this.boolVal;
	}
	
	@Override
	public void setByte(byte v) throws RemoteException {
		this.byteVal = v;
	}
	
	@Override
	public byte getByte() throws RemoteException {
		return byteVal;
	}
	
	@Override
	public void setChar(char v) throws RemoteException {
		charVal = v;
	}
	
	@Override
	public char getChar() throws RemoteException {
		return charVal;
	}
	
	@Override
	public void setShort(short v) throws RemoteException {
		shortVal = v;
	}
	
	@Override
	public short getShort() throws RemoteException {
		return shortVal;
	}
	
	@Override
	public void setInt(int v) throws RemoteException {
		intVal = v;
	}
	
	@Override
	public int getInt() throws RemoteException {
		return intVal;
	}
	
	@Override
	public void setLong(long v) throws RemoteException {
		longVal = v;
	}
	
	@Override
	public long getLong() throws RemoteException {
		return longVal;
	}
	
	@Override
	public void setFloat(float v) throws RemoteException {
		floatVal = v;
	}
	
	@Override
	public float getFloat() throws RemoteException {
		return floatVal;
	}

	@Override
	public void setDouble(double v) throws RemoteException {
		doubleVal = v;
	}
	
	@Override
	public double getDouble() throws RemoteException {
		return doubleVal;
	}
	
	@Override
	public void setString(String v) throws RemoteException {
		stringVal = v;
	}
	
	@Override
	public String getString() throws RemoteException {
		return stringVal;
	}
	
	@Override
	public void setObject(Object v) throws RemoteException {
		objectVal = v;
	}
	
	@Override
	public Object getObject() throws RemoteException {
		return objectVal;
	}
	
	@Override
	public void setPrimitiveTypes(PrimitiveTypes v) throws RemoteException {
		primitiveTypesVal = v;
	}
	
	@Override
	public PrimitiveTypes getPrimitiveTypes() throws RemoteException {
		return primitiveTypesVal;
	}
	
	@Override
	public void sendAllTypes(boolean b, char c, short s, int i, long l,
			float f, double d, String str, PrimitiveTypes pt, Object o)
			throws RemoteException {
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
