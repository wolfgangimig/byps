package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface RemotePrimitiveTypes.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemotePrimitiveTypes extends BSkeleton implements RemotePrimitiveTypes {
	
	public final static long serialVersionUID = 1341983932L;
	
	@Override
	public void voidFunctionVoid() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_voidFunctionVoid(final BAsyncResult<Object> asyncResult) {
		try {
			voidFunctionVoid();
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setBool(boolean v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setBool(boolean v, final BAsyncResult<Object> asyncResult) {
		try {
			setBool(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setByte(byte v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setByte(byte v, final BAsyncResult<Object> asyncResult) {
		try {
			setByte(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setChar(char v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setChar(char v, final BAsyncResult<Object> asyncResult) {
		try {
			setChar(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setShort(short v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setShort(short v, final BAsyncResult<Object> asyncResult) {
		try {
			setShort(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setInt(int v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setInt(int v, final BAsyncResult<Object> asyncResult) {
		try {
			setInt(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setLong(long v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setLong(long v, final BAsyncResult<Object> asyncResult) {
		try {
			setLong(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setFloat(float v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setFloat(float v, final BAsyncResult<Object> asyncResult) {
		try {
			setFloat(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setDouble(double v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setDouble(double v, final BAsyncResult<Object> asyncResult) {
		try {
			setDouble(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setString(java.lang.String v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setString(java.lang.String v, final BAsyncResult<Object> asyncResult) {
		try {
			setString(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v, final BAsyncResult<Object> asyncResult) {
		try {
			setPrimitiveTypes(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setObject(java.lang.Object v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setObject(java.lang.Object v, final BAsyncResult<Object> asyncResult) {
		try {
			setObject(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public boolean getBool() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getBool(final BAsyncResult<Boolean> asyncResult) {
		try {
			boolean ret = getBool();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public byte getByte() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getByte(final BAsyncResult<Byte> asyncResult) {
		try {
			byte ret = getByte();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public char getChar() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getChar(final BAsyncResult<Character> asyncResult) {
		try {
			char ret = getChar();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public short getShort() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getShort(final BAsyncResult<Short> asyncResult) {
		try {
			short ret = getShort();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public int getInt() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getInt(final BAsyncResult<Integer> asyncResult) {
		try {
			int ret = getInt();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public long getLong() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getLong(final BAsyncResult<Long> asyncResult) {
		try {
			long ret = getLong();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public float getFloat() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getFloat(final BAsyncResult<Float> asyncResult) {
		try {
			float ret = getFloat();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public double getDouble() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getDouble(final BAsyncResult<Double> asyncResult) {
		try {
			double ret = getDouble();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.lang.String getString() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getString(final BAsyncResult<String> asyncResult) {
		try {
			java.lang.String ret = getString();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public com.wilutions.byps.test.api.prim.PrimitiveTypes getPrimitiveTypes() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getPrimitiveTypes(final BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes> asyncResult) {
		try {
			com.wilutions.byps.test.api.prim.PrimitiveTypes ret = getPrimitiveTypes();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.lang.Object getObject() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getObject(final BAsyncResult<java.lang.Object> asyncResult) {
		try {
			java.lang.Object ret = getObject();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void sendAllTypes(boolean b, char c, short s, int i, long l, float f, double d, java.lang.String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, java.lang.Object o) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_sendAllTypes(boolean b, char c, short s, int i, long l, float f, double d, java.lang.String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, java.lang.Object o, final BAsyncResult<Object> asyncResult) {
		try {
			sendAllTypes(b, c, s, i, l, f, d, str, pt, o);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public int add(int a, int b) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_add(int a, int b, final BAsyncResult<Integer> asyncResult) {
		try {
			int ret = add(a, b);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
