package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * Interface with functions using 1-dimensional arrays.
 * @BRemote 
*/
public interface RemoteArrayTypes1dim extends BRemote {

	/**
	*/
	public void setBool(boolean[] v) throws BException, InterruptedException;
	public void async_setBool(boolean[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void setByte(byte[] v) throws BException, InterruptedException;
	public void async_setByte(byte[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void setChar(char[] v) throws BException, InterruptedException;
	public void async_setChar(char[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void setShort(short[] v) throws BException, InterruptedException;
	public void async_setShort(short[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void setInt(int[] v) throws BException, InterruptedException;
	public void async_setInt(int[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void setLong(long[] v) throws BException, InterruptedException;
	public void async_setLong(long[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void setFloat(float[] v) throws BException, InterruptedException;
	public void async_setFloat(float[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void setDouble(double[] v) throws BException, InterruptedException;
	public void async_setDouble(double[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void setString(java.lang.String[] v) throws BException, InterruptedException;
	public void async_setString(java.lang.String[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void setPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v) throws BException, InterruptedException;
	public void async_setPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void setObject(java.lang.Object[] v) throws BException, InterruptedException;
	public void async_setObject(java.lang.Object[] v, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public boolean[] getBool() throws BException, InterruptedException;
	public void async_getBool(final BAsyncResult<boolean[]> asyncResult) ;
	
	/**
	*/
	public byte[] getByte() throws BException, InterruptedException;
	public void async_getByte(final BAsyncResult<byte[]> asyncResult) ;
	
	/**
	*/
	public char[] getChar() throws BException, InterruptedException;
	public void async_getChar(final BAsyncResult<char[]> asyncResult) ;
	
	/**
	*/
	public short[] getShort() throws BException, InterruptedException;
	public void async_getShort(final BAsyncResult<short[]> asyncResult) ;
	
	/**
	*/
	public int[] getInt() throws BException, InterruptedException;
	public void async_getInt(final BAsyncResult<int[]> asyncResult) ;
	
	/**
	*/
	public long[] getLong() throws BException, InterruptedException;
	public void async_getLong(final BAsyncResult<long[]> asyncResult) ;
	
	/**
	*/
	public float[] getFloat() throws BException, InterruptedException;
	public void async_getFloat(final BAsyncResult<float[]> asyncResult) ;
	
	/**
	*/
	public double[] getDouble() throws BException, InterruptedException;
	public void async_getDouble(final BAsyncResult<double[]> asyncResult) ;
	
	/**
	*/
	public java.lang.String[] getString() throws BException, InterruptedException;
	public void async_getString(final BAsyncResult<java.lang.String[]> asyncResult) ;
	
	/**
	*/
	public com.wilutions.byps.test.api.prim.PrimitiveTypes[] getPrimitiveTypes() throws BException, InterruptedException;
	public void async_getPrimitiveTypes(final BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult) ;
	
	/**
	*/
	public java.lang.Object[] getObject() throws BException, InterruptedException;
	public void async_getObject(final BAsyncResult<java.lang.Object[]> asyncResult) ;
	
	
}
