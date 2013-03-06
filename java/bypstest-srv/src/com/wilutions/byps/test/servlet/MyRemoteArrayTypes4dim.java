package com.wilutions.byps.test.servlet;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteArrayTypes4dim;

public class MyRemoteArrayTypes4dim extends BSkeleton_RemoteArrayTypes4dim {

	public boolean[][][][] boolean1;
	public byte[][][][] byte1;
	public char[][][][] char1;
	public short[][][][] short1;
	public int[][][][] int1;
	public long[][][][] long1;
	public float[][][][] float1;
	public double[][][][] double1;
	public String[][][][] string1;
	public PrimitiveTypes[][][][] primitiveTypes1;
	public Object[][][][] object1;

	@Override
	public void setBool(boolean[][][][] v) throws BException, InterruptedException {
		boolean1 = v;
	}

	@Override
	public void setByte(byte[][][][] v) throws BException, InterruptedException {
		byte1 = v;
	}

	@Override
	public void setChar(char[][][][] v) throws BException, InterruptedException {
		char1 = v;
	}

	@Override
	public void setShort(short[][][][] v) throws BException, InterruptedException {
		short1 = v;
	}

	@Override
	public void setInt(int[][][][] v) throws BException, InterruptedException {
		int1 = v;
	}

	@Override
	public void setLong(long[][][][] v) throws BException, InterruptedException {
		long1 = v;
	}

	@Override
	public void setFloat(float[][][][] v) throws BException, InterruptedException {
		float1 = v;
	}

	@Override
	public void setDouble(double[][][][] v) throws BException, InterruptedException {
		double1 = v;
	}

	@Override
	public void setString(String[][][][] v) throws BException, InterruptedException {
		string1 = v;
	}

	@Override
	public void setPrimitiveTypes(PrimitiveTypes[][][][] v) throws BException,
			InterruptedException {
		primitiveTypes1 = v;
	}

	@Override
	public void setObject(Object[][][][] v) throws BException, InterruptedException {
		object1 = v;
	}

	@Override
	public boolean[][][][] getBool() throws BException, InterruptedException {
		return boolean1;
	}

	@Override
	public byte[][][][] getByte() throws BException, InterruptedException {
		return byte1;
	}

	@Override
	public char[][][][] getChar() throws BException, InterruptedException {
		return char1;
	}

	@Override
	public short[][][][] getShort() throws BException, InterruptedException {
		return short1;
	}

	@Override
	public int[][][][] getInt() throws BException, InterruptedException {
		return int1;
	}

	@Override
	public long[][][][] getLong() throws BException, InterruptedException {
		return long1;
	}

	@Override
	public float[][][][] getFloat() throws BException, InterruptedException {
		return float1;
	}

	@Override
	public double[][][][] getDouble() throws BException, InterruptedException {
		return double1;
	}

	@Override
	public String[][][][] getString() throws BException, InterruptedException {
		return string1;
	}

	@Override
	public PrimitiveTypes[][][][] getPrimitiveTypes() throws BException,
			InterruptedException {
		return primitiveTypes1;
	}

	@Override
	public Object[][][][] getObject() throws BException, InterruptedException {
		return object1;
	}

}
