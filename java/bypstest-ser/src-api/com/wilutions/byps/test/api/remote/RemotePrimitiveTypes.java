package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
public interface RemotePrimitiveTypes extends BRemote {

	/**
	*/
	public void voidFunctionVoid() throws BException, InterruptedException;
	
	/**
	*/
	public void setBool(boolean v) throws BException, InterruptedException;
	
	/**
	*/
	public void setByte(byte v) throws BException, InterruptedException;
	
	/**
	*/
	public void setChar(char v) throws BException, InterruptedException;
	
	/**
	*/
	public void setShort(short v) throws BException, InterruptedException;
	
	/**
	*/
	public void setInt(int v) throws BException, InterruptedException;
	
	/**
	*/
	public void setLong(long v) throws BException, InterruptedException;
	
	/**
	*/
	public void setFloat(float v) throws BException, InterruptedException;
	
	/**
	*/
	public void setDouble(double v) throws BException, InterruptedException;
	
	/**
	*/
	public void setString(java.lang.String v) throws BException, InterruptedException;
	
	/**
	*/
	public void setPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v) throws BException, InterruptedException;
	
	/**
	*/
	public void setObject(java.lang.Object v) throws BException, InterruptedException;
	
	/**
	*/
	public boolean getBool() throws BException, InterruptedException;
	
	/**
	*/
	public byte getByte() throws BException, InterruptedException;
	
	/**
	*/
	public char getChar() throws BException, InterruptedException;
	
	/**
	*/
	public short getShort() throws BException, InterruptedException;
	
	/**
	*/
	public int getInt() throws BException, InterruptedException;
	
	/**
	*/
	public long getLong() throws BException, InterruptedException;
	
	/**
	*/
	public float getFloat() throws BException, InterruptedException;
	
	/**
	*/
	public double getDouble() throws BException, InterruptedException;
	
	/**
	*/
	public java.lang.String getString() throws BException, InterruptedException;
	
	/**
	*/
	public com.wilutions.byps.test.api.prim.PrimitiveTypes getPrimitiveTypes() throws BException, InterruptedException;
	
	/**
	*/
	public java.lang.Object getObject() throws BException, InterruptedException;
	
	/**
	*/
	public void sendAllTypes(boolean b, char c, short s, int i, long l, float f, double d, java.lang.String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, java.lang.Object o) throws BException, InterruptedException;
	
	/**
	*/
	public int add(int a, int b) throws BException, InterruptedException;
	
	
}
