package com.wilutions.byps.test.api.remote;

import com.wilutions.byps.test.api.prim.PrimitiveTypes;


/**
 * 
 * @BRemote
 *
 */
public interface RemotePrimitiveTypes {

	public void voidFunctionVoid();
	
	public void setBool(boolean v);
	public void setByte(byte v);
	public void setChar(char v);
	public void setShort(short v);
	public void setInt(int v);
	public void setLong(long v);
	public void setFloat(float v);
	public void setDouble(double v);
	public void setString(String v);
	public void setPrimitiveTypes(PrimitiveTypes v);
	public void setObject(Object v);

	public boolean getBool();
	public byte getByte();
	public char getChar();
	public short getShort();
	public int getInt();
	public long getLong();
	public float getFloat();
	public double getDouble();
	public String getString();
	public PrimitiveTypes getPrimitiveTypes();
	public Object getObject();

	public void sendAllTypes(boolean b, char c, short s, int i, long l, float f, double d, String str, PrimitiveTypes pt, Object o);
	
	public int add(int a, int b);
}