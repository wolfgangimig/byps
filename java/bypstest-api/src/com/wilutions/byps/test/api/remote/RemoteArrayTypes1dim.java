package com.wilutions.byps.test.api.remote;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;

/**
 * Interface with functions using 1-dimensional arrays.
 * 
 *
 */
public interface RemoteArrayTypes1dim extends BRemote {
	
	public void setBool(boolean[] v) throws BException, InterruptedException;
	public void setByte(byte[] v) throws BException, InterruptedException;
	public void setChar(char[] v) throws BException, InterruptedException;
	public void setShort(short[] v) throws BException, InterruptedException;
	public void setInt(int[] v) throws BException, InterruptedException;
	public void setLong(long[] v) throws BException, InterruptedException;
	public void setFloat(float[] v) throws BException, InterruptedException;
	public void setDouble(double[] v) throws BException, InterruptedException;
	public void setString(String[] v) throws BException, InterruptedException;
	public void setPrimitiveTypes(PrimitiveTypes[] v) throws BException, InterruptedException;
	public void setObject(Object[] v) throws BException, InterruptedException;

	public boolean[] getBool() throws BException, InterruptedException;
	public byte[] getByte() throws BException, InterruptedException;
	public char[] getChar() throws BException, InterruptedException;
	public short[] getShort() throws BException, InterruptedException;
	public int[] getInt() throws BException, InterruptedException;
	public long[] getLong() throws BException, InterruptedException;
	public float[] getFloat() throws BException, InterruptedException;
	public double[] getDouble() throws BException, InterruptedException;
	public String[] getString() throws BException, InterruptedException;
	public PrimitiveTypes[] getPrimitiveTypes() throws BException, InterruptedException;
	public Object[] getObject() throws BException, InterruptedException;

}
