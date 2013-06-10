package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public interface RemotePrimitiveTypesAsync extends RemotePrimitiveTypes, BRemote {

	public void async_voidFunctionVoid(final BAsyncResult<Object> asyncResult) ;
	
	public void async_setBool(boolean v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_setByte(byte v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_setChar(char v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_setShort(short v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_setInt(int v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_setLong(long v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_setFloat(float v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_setDouble(double v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_setString(java.lang.String v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_setPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_setObject(java.lang.Object v, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getBool(final BAsyncResult<Boolean> asyncResult) ;
	
	public void async_getByte(final BAsyncResult<Byte> asyncResult) ;
	
	public void async_getChar(final BAsyncResult<Character> asyncResult) ;
	
	public void async_getShort(final BAsyncResult<Short> asyncResult) ;
	
	public void async_getInt(final BAsyncResult<Integer> asyncResult) ;
	
	public void async_getLong(final BAsyncResult<Long> asyncResult) ;
	
	public void async_getFloat(final BAsyncResult<Float> asyncResult) ;
	
	public void async_getDouble(final BAsyncResult<Double> asyncResult) ;
	
	public void async_getString(final BAsyncResult<String> asyncResult) ;
	
	public void async_getPrimitiveTypes(final BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes> asyncResult) ;
	
	public void async_getObject(final BAsyncResult<java.lang.Object> asyncResult) ;
	
	public void async_sendAllTypes(boolean b, char c, short s, int i, long l, float f, double d, java.lang.String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, java.lang.Object o, final BAsyncResult<Object> asyncResult) ;
	
	public void async_add(int a, int b, final BAsyncResult<Integer> asyncResult) ;
	
	
}
