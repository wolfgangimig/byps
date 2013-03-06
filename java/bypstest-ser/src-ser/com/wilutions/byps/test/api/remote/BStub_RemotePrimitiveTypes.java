package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class BStub_RemotePrimitiveTypes extends BStub implements RemotePrimitiveTypes, java.io.Serializable {
	
	public final static long serialVersionUID = 1341983932L;
	
	public BStub_RemotePrimitiveTypes(final BTransport transport) {
		super(transport);		
	}
	
	public void voidFunctionVoid() throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_voidFunctionVoid(asyncResult);
		asyncResult.getResult();		
	}
	public void async_voidFunctionVoid(final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_voidFunctionVoid req = new BRequest_RemotePrimitiveTypes_voidFunctionVoid();		
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setBool(boolean v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setBool(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setBool(boolean v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setBool req = new BRequest_RemotePrimitiveTypes_setBool();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setByte(byte v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setByte(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setByte(byte v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setByte req = new BRequest_RemotePrimitiveTypes_setByte();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setChar(char v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setChar(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setChar(char v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setChar req = new BRequest_RemotePrimitiveTypes_setChar();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setShort(short v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setShort(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setShort(short v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setShort req = new BRequest_RemotePrimitiveTypes_setShort();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setInt(int v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setInt(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setInt(int v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setInt req = new BRequest_RemotePrimitiveTypes_setInt();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setLong(long v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setLong(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setLong(long v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setLong req = new BRequest_RemotePrimitiveTypes_setLong();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setFloat(float v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setFloat(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setFloat(float v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setFloat req = new BRequest_RemotePrimitiveTypes_setFloat();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setDouble(double v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setDouble(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setDouble(double v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setDouble req = new BRequest_RemotePrimitiveTypes_setDouble();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setString(java.lang.String v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setString(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setString(java.lang.String v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setString req = new BRequest_RemotePrimitiveTypes_setString();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setPrimitiveTypes(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setPrimitiveTypes req = new BRequest_RemotePrimitiveTypes_setPrimitiveTypes();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setObject(java.lang.Object v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setObject(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setObject(java.lang.Object v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_setObject req = new BRequest_RemotePrimitiveTypes_setObject();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public boolean getBool() throws BException, InterruptedException {
		final BSyncResult<Boolean> asyncResult = new BSyncResult<Boolean>();		
		async_getBool(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getBool(final BAsyncResult<Boolean> asyncResult) {
		BRequest_RemotePrimitiveTypes_getBool req = new BRequest_RemotePrimitiveTypes_getBool();		
		BAsyncResultReceiveMethod<Boolean> outerResult = new BAsyncResultReceiveMethod<Boolean>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public byte getByte() throws BException, InterruptedException {
		final BSyncResult<Byte> asyncResult = new BSyncResult<Byte>();		
		async_getByte(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getByte(final BAsyncResult<Byte> asyncResult) {
		BRequest_RemotePrimitiveTypes_getByte req = new BRequest_RemotePrimitiveTypes_getByte();		
		BAsyncResultReceiveMethod<Byte> outerResult = new BAsyncResultReceiveMethod<Byte>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public char getChar() throws BException, InterruptedException {
		final BSyncResult<Character> asyncResult = new BSyncResult<Character>();		
		async_getChar(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getChar(final BAsyncResult<Character> asyncResult) {
		BRequest_RemotePrimitiveTypes_getChar req = new BRequest_RemotePrimitiveTypes_getChar();		
		BAsyncResultReceiveMethod<Character> outerResult = new BAsyncResultReceiveMethod<Character>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public short getShort() throws BException, InterruptedException {
		final BSyncResult<Short> asyncResult = new BSyncResult<Short>();		
		async_getShort(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getShort(final BAsyncResult<Short> asyncResult) {
		BRequest_RemotePrimitiveTypes_getShort req = new BRequest_RemotePrimitiveTypes_getShort();		
		BAsyncResultReceiveMethod<Short> outerResult = new BAsyncResultReceiveMethod<Short>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public int getInt() throws BException, InterruptedException {
		final BSyncResult<Integer> asyncResult = new BSyncResult<Integer>();		
		async_getInt(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getInt(final BAsyncResult<Integer> asyncResult) {
		BRequest_RemotePrimitiveTypes_getInt req = new BRequest_RemotePrimitiveTypes_getInt();		
		BAsyncResultReceiveMethod<Integer> outerResult = new BAsyncResultReceiveMethod<Integer>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public long getLong() throws BException, InterruptedException {
		final BSyncResult<Long> asyncResult = new BSyncResult<Long>();		
		async_getLong(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getLong(final BAsyncResult<Long> asyncResult) {
		BRequest_RemotePrimitiveTypes_getLong req = new BRequest_RemotePrimitiveTypes_getLong();		
		BAsyncResultReceiveMethod<Long> outerResult = new BAsyncResultReceiveMethod<Long>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public float getFloat() throws BException, InterruptedException {
		final BSyncResult<Float> asyncResult = new BSyncResult<Float>();		
		async_getFloat(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getFloat(final BAsyncResult<Float> asyncResult) {
		BRequest_RemotePrimitiveTypes_getFloat req = new BRequest_RemotePrimitiveTypes_getFloat();		
		BAsyncResultReceiveMethod<Float> outerResult = new BAsyncResultReceiveMethod<Float>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public double getDouble() throws BException, InterruptedException {
		final BSyncResult<Double> asyncResult = new BSyncResult<Double>();		
		async_getDouble(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getDouble(final BAsyncResult<Double> asyncResult) {
		BRequest_RemotePrimitiveTypes_getDouble req = new BRequest_RemotePrimitiveTypes_getDouble();		
		BAsyncResultReceiveMethod<Double> outerResult = new BAsyncResultReceiveMethod<Double>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.lang.String getString() throws BException, InterruptedException {
		final BSyncResult<String> asyncResult = new BSyncResult<String>();		
		async_getString(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getString(final BAsyncResult<String> asyncResult) {
		BRequest_RemotePrimitiveTypes_getString req = new BRequest_RemotePrimitiveTypes_getString();		
		BAsyncResultReceiveMethod<String> outerResult = new BAsyncResultReceiveMethod<String>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public com.wilutions.byps.test.api.prim.PrimitiveTypes getPrimitiveTypes() throws BException, InterruptedException {
		final BSyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes> asyncResult = new BSyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes>();		
		async_getPrimitiveTypes(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getPrimitiveTypes(final BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes> asyncResult) {
		BRequest_RemotePrimitiveTypes_getPrimitiveTypes req = new BRequest_RemotePrimitiveTypes_getPrimitiveTypes();		
		BAsyncResultReceiveMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.lang.Object getObject() throws BException, InterruptedException {
		final BSyncResult<java.lang.Object> asyncResult = new BSyncResult<java.lang.Object>();		
		async_getObject(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getObject(final BAsyncResult<java.lang.Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_getObject req = new BRequest_RemotePrimitiveTypes_getObject();		
		BAsyncResultReceiveMethod<java.lang.Object> outerResult = new BAsyncResultReceiveMethod<java.lang.Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void sendAllTypes(boolean b, char c, short s, int i, long l, float f, double d, java.lang.String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, java.lang.Object o) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_sendAllTypes(b, c, s, i, l, f, d, str, pt, o, asyncResult);
		asyncResult.getResult();		
	}
	public void async_sendAllTypes(boolean b, char c, short s, int i, long l, float f, double d, java.lang.String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, java.lang.Object o, final BAsyncResult<Object> asyncResult) {
		BRequest_RemotePrimitiveTypes_sendAllTypes req = new BRequest_RemotePrimitiveTypes_sendAllTypes();		
		req.b = b;
		req.c = c;
		req.s = s;
		req.i = i;
		req.l = l;
		req.f = f;
		req.d = d;
		req.str = str;
		req.pt = pt;
		req.o = o;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public int add(int a, int b) throws BException, InterruptedException {
		final BSyncResult<Integer> asyncResult = new BSyncResult<Integer>();		
		async_add(a, b, asyncResult);
		return asyncResult.getResult();		
	}
	public void async_add(int a, int b, final BAsyncResult<Integer> asyncResult) {
		BRequest_RemotePrimitiveTypes_add req = new BRequest_RemotePrimitiveTypes_add();		
		req.a = a;
		req.b = b;
		BAsyncResultReceiveMethod<Integer> outerResult = new BAsyncResultReceiveMethod<Integer>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}
