﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class BStub_RemoteSetTypes extends BStub implements RemoteSetTypes, java.io.Serializable {
	
	public final static long serialVersionUID = 1156008353L;
	
	public BStub_RemoteSetTypes(final BTransport transport) {
		super(transport);		
	}
	
	public java.util.Set<java.lang.Boolean> getBoolean1() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<java.lang.Boolean>> asyncResult = new BSyncResult<java.util.Set<java.lang.Boolean>>();		
		async_getBoolean1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getBoolean1(final BAsyncResult<java.util.Set<java.lang.Boolean>> asyncResult) {
		BRequest_RemoteSetTypes_getBoolean1 req = new BRequest_RemoteSetTypes_getBoolean1();		
		BAsyncResultReceiveMethod<java.util.Set<java.lang.Boolean>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<java.lang.Boolean>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setBoolean1(java.util.Set<java.lang.Boolean> boolean1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setBoolean1(boolean1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setBoolean1(java.util.Set<java.lang.Boolean> boolean1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setBoolean1 req = new BRequest_RemoteSetTypes_setBoolean1();		
		req.boolean1 = boolean1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.HashSet<java.lang.Byte> getByte1() throws BException, InterruptedException {
		final BSyncResult<java.util.HashSet<java.lang.Byte>> asyncResult = new BSyncResult<java.util.HashSet<java.lang.Byte>>();		
		async_getByte1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getByte1(final BAsyncResult<java.util.HashSet<java.lang.Byte>> asyncResult) {
		BRequest_RemoteSetTypes_getByte1 req = new BRequest_RemoteSetTypes_getByte1();		
		BAsyncResultReceiveMethod<java.util.HashSet<java.lang.Byte>> outerResult = new BAsyncResultReceiveMethod<java.util.HashSet<java.lang.Byte>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setByte1(java.util.HashSet<java.lang.Byte> byte1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setByte1(byte1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setByte1(java.util.HashSet<java.lang.Byte> byte1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setByte1 req = new BRequest_RemoteSetTypes_setByte1();		
		req.byte1 = byte1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.TreeSet<java.lang.Character> getChar1() throws BException, InterruptedException {
		final BSyncResult<java.util.TreeSet<java.lang.Character>> asyncResult = new BSyncResult<java.util.TreeSet<java.lang.Character>>();		
		async_getChar1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getChar1(final BAsyncResult<java.util.TreeSet<java.lang.Character>> asyncResult) {
		BRequest_RemoteSetTypes_getChar1 req = new BRequest_RemoteSetTypes_getChar1();		
		BAsyncResultReceiveMethod<java.util.TreeSet<java.lang.Character>> outerResult = new BAsyncResultReceiveMethod<java.util.TreeSet<java.lang.Character>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setChar1(java.util.TreeSet<java.lang.Character> char1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setChar1(char1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setChar1(java.util.TreeSet<java.lang.Character> char1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setChar1 req = new BRequest_RemoteSetTypes_setChar1();		
		req.char1 = char1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<java.lang.Short> getShort1() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<java.lang.Short>> asyncResult = new BSyncResult<java.util.Set<java.lang.Short>>();		
		async_getShort1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getShort1(final BAsyncResult<java.util.Set<java.lang.Short>> asyncResult) {
		BRequest_RemoteSetTypes_getShort1 req = new BRequest_RemoteSetTypes_getShort1();		
		BAsyncResultReceiveMethod<java.util.Set<java.lang.Short>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<java.lang.Short>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setShort1(java.util.Set<java.lang.Short> short1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setShort1(short1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setShort1(java.util.Set<java.lang.Short> short1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setShort1 req = new BRequest_RemoteSetTypes_setShort1();		
		req.short1 = short1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<java.lang.Integer> getInt1() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<java.lang.Integer>> asyncResult = new BSyncResult<java.util.Set<java.lang.Integer>>();		
		async_getInt1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getInt1(final BAsyncResult<java.util.Set<java.lang.Integer>> asyncResult) {
		BRequest_RemoteSetTypes_getInt1 req = new BRequest_RemoteSetTypes_getInt1();		
		BAsyncResultReceiveMethod<java.util.Set<java.lang.Integer>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<java.lang.Integer>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setInt1(java.util.Set<java.lang.Integer> int1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setInt1(int1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setInt1(java.util.Set<java.lang.Integer> int1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setInt1 req = new BRequest_RemoteSetTypes_setInt1();		
		req.int1 = int1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<java.lang.Long> getLong1() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<java.lang.Long>> asyncResult = new BSyncResult<java.util.Set<java.lang.Long>>();		
		async_getLong1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getLong1(final BAsyncResult<java.util.Set<java.lang.Long>> asyncResult) {
		BRequest_RemoteSetTypes_getLong1 req = new BRequest_RemoteSetTypes_getLong1();		
		BAsyncResultReceiveMethod<java.util.Set<java.lang.Long>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<java.lang.Long>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setLong1(java.util.Set<java.lang.Long> long1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setLong1(long1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setLong1(java.util.Set<java.lang.Long> long1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setLong1 req = new BRequest_RemoteSetTypes_setLong1();		
		req.long1 = long1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<java.lang.Float> getFloat1() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<java.lang.Float>> asyncResult = new BSyncResult<java.util.Set<java.lang.Float>>();		
		async_getFloat1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getFloat1(final BAsyncResult<java.util.Set<java.lang.Float>> asyncResult) {
		BRequest_RemoteSetTypes_getFloat1 req = new BRequest_RemoteSetTypes_getFloat1();		
		BAsyncResultReceiveMethod<java.util.Set<java.lang.Float>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<java.lang.Float>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setFloat1(java.util.Set<java.lang.Float> float1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setFloat1(float1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setFloat1(java.util.Set<java.lang.Float> float1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setFloat1 req = new BRequest_RemoteSetTypes_setFloat1();		
		req.float1 = float1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<java.lang.Double> getDouble1() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<java.lang.Double>> asyncResult = new BSyncResult<java.util.Set<java.lang.Double>>();		
		async_getDouble1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getDouble1(final BAsyncResult<java.util.Set<java.lang.Double>> asyncResult) {
		BRequest_RemoteSetTypes_getDouble1 req = new BRequest_RemoteSetTypes_getDouble1();		
		BAsyncResultReceiveMethod<java.util.Set<java.lang.Double>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<java.lang.Double>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setDouble1(java.util.Set<java.lang.Double> double1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setDouble1(double1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setDouble1(java.util.Set<java.lang.Double> double1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setDouble1 req = new BRequest_RemoteSetTypes_setDouble1();		
		req.double1 = double1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<java.lang.String> getString1() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<java.lang.String>> asyncResult = new BSyncResult<java.util.Set<java.lang.String>>();		
		async_getString1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getString1(final BAsyncResult<java.util.Set<java.lang.String>> asyncResult) {
		BRequest_RemoteSetTypes_getString1 req = new BRequest_RemoteSetTypes_getString1();		
		BAsyncResultReceiveMethod<java.util.Set<java.lang.String>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<java.lang.String>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setString1(java.util.Set<java.lang.String> string1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setString1(string1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setString1(java.util.Set<java.lang.String> string1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setString1 req = new BRequest_RemoteSetTypes_setString1();		
		req.string1 = string1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes> getPrimitiveTypes1() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>>();		
		async_getPrimitiveTypes1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getPrimitiveTypes1(final BAsyncResult<java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
		BRequest_RemoteSetTypes_getPrimitiveTypes1 req = new BRequest_RemoteSetTypes_getPrimitiveTypes1();		
		BAsyncResultReceiveMethod<java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setPrimitiveTypes1(java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setPrimitiveTypes1(primitiveTypes1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setPrimitiveTypes1(java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setPrimitiveTypes1 req = new BRequest_RemoteSetTypes_setPrimitiveTypes1();		
		req.primitiveTypes1 = primitiveTypes1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<byte[]> getByte2() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<byte[]>> asyncResult = new BSyncResult<java.util.Set<byte[]>>();		
		async_getByte2(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getByte2(final BAsyncResult<java.util.Set<byte[]>> asyncResult) {
		BRequest_RemoteSetTypes_getByte2 req = new BRequest_RemoteSetTypes_getByte2();		
		BAsyncResultReceiveMethod<java.util.Set<byte[]>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<byte[]>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setByte2(java.util.Set<byte[]> byte2) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setByte2(byte2, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setByte2(java.util.Set<byte[]> byte2, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setByte2 req = new BRequest_RemoteSetTypes_setByte2();		
		req.byte2 = byte2;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<int[]> getInt2() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<int[]>> asyncResult = new BSyncResult<java.util.Set<int[]>>();		
		async_getInt2(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getInt2(final BAsyncResult<java.util.Set<int[]>> asyncResult) {
		BRequest_RemoteSetTypes_getInt2 req = new BRequest_RemoteSetTypes_getInt2();		
		BAsyncResultReceiveMethod<java.util.Set<int[]>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<int[]>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setInt2(java.util.Set<int[]> int2) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setInt2(int2, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setInt2(java.util.Set<int[]> int2, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setInt2 req = new BRequest_RemoteSetTypes_setInt2();		
		req.int2 = int2;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.Set<java.lang.Object> getObj1() throws BException, InterruptedException {
		final BSyncResult<java.util.Set<java.lang.Object>> asyncResult = new BSyncResult<java.util.Set<java.lang.Object>>();		
		async_getObj1(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getObj1(final BAsyncResult<java.util.Set<java.lang.Object>> asyncResult) {
		BRequest_RemoteSetTypes_getObj1 req = new BRequest_RemoteSetTypes_getObj1();		
		BAsyncResultReceiveMethod<java.util.Set<java.lang.Object>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<java.lang.Object>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setObj1(java.util.Set<java.lang.Object> obj1) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setObj1(obj1, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setObj1(java.util.Set<java.lang.Object> obj1, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteSetTypes_setObj1 req = new BRequest_RemoteSetTypes_setObj1();		
		req.obj1 = obj1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}