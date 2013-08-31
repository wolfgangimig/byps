﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenRemoteStub DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:159
public class BStub_RemoteListTypes extends BStub implements RemoteListTypesAsync, java.io.Serializable {
	
	public final static long serialVersionUID = 0L;
	
	public BStub_RemoteListTypes(final BTransport transport) {
		super(transport);		
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.lang.Boolean> getBoolean1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.lang.Boolean>> asyncResult = new BSyncResult<java.util.List<java.lang.Boolean>>();		
		async_getBoolean1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getBoolean1(final BAsyncResult<java.util.List<java.lang.Boolean>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getBoolean1 req = new BRequest_RemoteListTypes_getBoolean1();		
		BAsyncResultReceiveMethod<java.util.List<java.lang.Boolean>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.lang.Boolean>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setBoolean1(java.util.List<java.lang.Boolean> boolean1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setBoolean1(boolean1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setBoolean1(java.util.List<java.lang.Boolean> boolean1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setBoolean1 req = new BRequest_RemoteListTypes_setBoolean1();		
		req.boolean1 = boolean1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.lang.Byte> getByte1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.lang.Byte>> asyncResult = new BSyncResult<java.util.List<java.lang.Byte>>();		
		async_getByte1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getByte1(final BAsyncResult<java.util.List<java.lang.Byte>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getByte1 req = new BRequest_RemoteListTypes_getByte1();		
		BAsyncResultReceiveMethod<java.util.List<java.lang.Byte>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.lang.Byte>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setByte1(java.util.List<java.lang.Byte> byte1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setByte1(byte1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setByte1(java.util.List<java.lang.Byte> byte1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setByte1 req = new BRequest_RemoteListTypes_setByte1();		
		req.byte1 = byte1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.lang.Character> getChar1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.lang.Character>> asyncResult = new BSyncResult<java.util.List<java.lang.Character>>();		
		async_getChar1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getChar1(final BAsyncResult<java.util.List<java.lang.Character>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getChar1 req = new BRequest_RemoteListTypes_getChar1();		
		BAsyncResultReceiveMethod<java.util.List<java.lang.Character>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.lang.Character>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setChar1(java.util.List<java.lang.Character> char1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setChar1(char1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setChar1(java.util.List<java.lang.Character> char1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setChar1 req = new BRequest_RemoteListTypes_setChar1();		
		req.char1 = char1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.lang.Short> getShort1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.lang.Short>> asyncResult = new BSyncResult<java.util.List<java.lang.Short>>();		
		async_getShort1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getShort1(final BAsyncResult<java.util.List<java.lang.Short>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getShort1 req = new BRequest_RemoteListTypes_getShort1();		
		BAsyncResultReceiveMethod<java.util.List<java.lang.Short>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.lang.Short>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setShort1(java.util.List<java.lang.Short> short1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setShort1(short1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setShort1(java.util.List<java.lang.Short> short1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setShort1 req = new BRequest_RemoteListTypes_setShort1();		
		req.short1 = short1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.lang.Integer> getInt1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.lang.Integer>> asyncResult = new BSyncResult<java.util.List<java.lang.Integer>>();		
		async_getInt1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getInt1(final BAsyncResult<java.util.List<java.lang.Integer>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getInt1 req = new BRequest_RemoteListTypes_getInt1();		
		BAsyncResultReceiveMethod<java.util.List<java.lang.Integer>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.lang.Integer>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setInt1(java.util.List<java.lang.Integer> int1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setInt1(int1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setInt1(java.util.List<java.lang.Integer> int1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setInt1 req = new BRequest_RemoteListTypes_setInt1();		
		req.int1 = int1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.lang.Long> getLong1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.lang.Long>> asyncResult = new BSyncResult<java.util.List<java.lang.Long>>();		
		async_getLong1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getLong1(final BAsyncResult<java.util.List<java.lang.Long>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getLong1 req = new BRequest_RemoteListTypes_getLong1();		
		BAsyncResultReceiveMethod<java.util.List<java.lang.Long>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.lang.Long>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setLong1(java.util.List<java.lang.Long> long1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setLong1(long1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setLong1(java.util.List<java.lang.Long> long1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setLong1 req = new BRequest_RemoteListTypes_setLong1();		
		req.long1 = long1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.lang.Float> getFloat1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.lang.Float>> asyncResult = new BSyncResult<java.util.List<java.lang.Float>>();		
		async_getFloat1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getFloat1(final BAsyncResult<java.util.List<java.lang.Float>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getFloat1 req = new BRequest_RemoteListTypes_getFloat1();		
		BAsyncResultReceiveMethod<java.util.List<java.lang.Float>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.lang.Float>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setFloat1(java.util.List<java.lang.Float> float1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setFloat1(float1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setFloat1(java.util.List<java.lang.Float> float1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setFloat1 req = new BRequest_RemoteListTypes_setFloat1();		
		req.float1 = float1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.lang.Double> getDouble1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.lang.Double>> asyncResult = new BSyncResult<java.util.List<java.lang.Double>>();		
		async_getDouble1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getDouble1(final BAsyncResult<java.util.List<java.lang.Double>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getDouble1 req = new BRequest_RemoteListTypes_getDouble1();		
		BAsyncResultReceiveMethod<java.util.List<java.lang.Double>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.lang.Double>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setDouble1(java.util.List<java.lang.Double> double1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setDouble1(double1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setDouble1(java.util.List<java.lang.Double> double1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setDouble1 req = new BRequest_RemoteListTypes_setDouble1();		
		req.double1 = double1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.lang.String> getString1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.lang.String>> asyncResult = new BSyncResult<java.util.List<java.lang.String>>();		
		async_getString1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getString1(final BAsyncResult<java.util.List<java.lang.String>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getString1 req = new BRequest_RemoteListTypes_getString1();		
		BAsyncResultReceiveMethod<java.util.List<java.lang.String>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.lang.String>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setString1(java.util.List<java.lang.String> string1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setString1(string1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setString1(java.util.List<java.lang.String> string1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setString1 req = new BRequest_RemoteListTypes_setString1();		
		req.string1 = string1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes> getPrimitiveTypes1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>>();		
		async_getPrimitiveTypes1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getPrimitiveTypes1(final BAsyncResult<java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getPrimitiveTypes1 req = new BRequest_RemoteListTypes_getPrimitiveTypes1();		
		BAsyncResultReceiveMethod<java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>> outerResult = new BAsyncResultReceiveMethod<java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setPrimitiveTypes1(java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setPrimitiveTypes1(primitiveTypes1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setPrimitiveTypes1(java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setPrimitiveTypes1 req = new BRequest_RemoteListTypes_setPrimitiveTypes1();		
		req.primitiveTypes1 = primitiveTypes1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<byte[]> getByte2() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<byte[]>> asyncResult = new BSyncResult<java.util.List<byte[]>>();		
		async_getByte2(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getByte2(final BAsyncResult<java.util.List<byte[]>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getByte2 req = new BRequest_RemoteListTypes_getByte2();		
		BAsyncResultReceiveMethod<java.util.List<byte[]>> outerResult = new BAsyncResultReceiveMethod<java.util.List<byte[]>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setByte2(java.util.List<byte[]> byte2) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setByte2(byte2, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setByte2(java.util.List<byte[]> byte2, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setByte2 req = new BRequest_RemoteListTypes_setByte2();		
		req.byte2 = byte2;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<int[]> getInt2() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<int[]>> asyncResult = new BSyncResult<java.util.List<int[]>>();		
		async_getInt2(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getInt2(final BAsyncResult<java.util.List<int[]>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getInt2 req = new BRequest_RemoteListTypes_getInt2();		
		BAsyncResultReceiveMethod<java.util.List<int[]>> outerResult = new BAsyncResultReceiveMethod<java.util.List<int[]>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setInt2(java.util.List<int[]> int2) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setInt2(int2, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setInt2(java.util.List<int[]> int2, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setInt2 req = new BRequest_RemoteListTypes_setInt2();		
		req.int2 = int2;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.lang.Object> getObj1() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.lang.Object>> asyncResult = new BSyncResult<java.util.List<java.lang.Object>>();		
		async_getObj1(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getObj1(final BAsyncResult<java.util.List<java.lang.Object>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getObj1 req = new BRequest_RemoteListTypes_getObj1();		
		BAsyncResultReceiveMethod<java.util.List<java.lang.Object>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.lang.Object>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setObj1(java.util.List<java.lang.Object> obj1) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setObj1(obj1, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setObj1(java.util.List<java.lang.Object> obj1, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setObj1 req = new BRequest_RemoteListTypes_setObj1();		
		req.obj1 = obj1;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.util.List<java.lang.Integer>> getInt3() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.util.List<java.lang.Integer>>> asyncResult = new BSyncResult<java.util.List<java.util.List<java.lang.Integer>>>();		
		async_getInt3(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getInt3(final BAsyncResult<java.util.List<java.util.List<java.lang.Integer>>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getInt3 req = new BRequest_RemoteListTypes_getInt3();		
		BAsyncResultReceiveMethod<java.util.List<java.util.List<java.lang.Integer>>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.util.List<java.lang.Integer>>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setInt3(java.util.List<java.util.List<java.lang.Integer>> int3) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setInt3(int3, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setInt3(java.util.List<java.util.List<java.lang.Integer>> int3, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setInt3 req = new BRequest_RemoteListTypes_setInt3();		
		req.int3 = int3;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>> getInt4() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>> asyncResult = new BSyncResult<java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>>();		
		async_getInt4(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getInt4(final BAsyncResult<java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_getInt4 req = new BRequest_RemoteListTypes_getInt4();		
		BAsyncResultReceiveMethod<java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setInt4(java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>> int4) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setInt4(int4, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setInt4(java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>> int4, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteListTypes_setInt4 req = new BRequest_RemoteListTypes_setInt4();		
		req.int4 = int4;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}
