package com.wilutions.byps.test.api.remote;

import com.wilutions.byps.test.api.prim.PrimitiveTypes;

/**
 * Interface with functions using 4-dimensional arrays.
 * @BRemote
 *
 */
public interface RemoteArrayTypes4dim {
	
	public void setBool(boolean[][][][] v);
	public void setByte(byte[][][][] v);
	public void setChar(char[][][][] v);
	public void setShort(short[][][][] v);
	public void setInt(int[][][][] v);
	public void setLong(long[][][][] v);
	public void setFloat(float[][][][] v);
	public void setDouble(double[][][][] v);
	public void setString(String[][][][] v);
	public void setPrimitiveTypes(PrimitiveTypes[][][][] v);
	public void setObject(Object[][][][] v);

	public boolean[][][][] getBool();
	public byte[][][][] getByte();
	public char[][][][] getChar();
	public short[][][][] getShort();
	public int[][][][] getInt();
	public long[][][][] getLong();
	public float[][][][] getFloat();
	public double[][][][] getDouble();
	public String[][][][] getString();
	public PrimitiveTypes[][][][] getPrimitiveTypes();
	public Object[][][][] getObject();

}
