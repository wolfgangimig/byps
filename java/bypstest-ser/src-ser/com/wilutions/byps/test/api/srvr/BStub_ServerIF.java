﻿package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenRemoteStub DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:159
public class BStub_ServerIF extends BStub implements ServerIFAsync, java.io.Serializable {
	
	public final static long serialVersionUID = 0L;
	
	public BStub_ServerIF(final BTransport transport) {
		super(transport);		
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public int callClientIncrementInt(int v) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Integer> asyncResult = new BSyncResult<Integer>();		
		async_callClientIncrementInt(v, asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_callClientIncrementInt(int v, final BAsyncResult<Integer> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_ServerIF_callClientIncrementInt req = new BRequest_ServerIF_callClientIncrementInt();		
		req.v = v;
		BAsyncResultReceiveMethod<Integer> outerResult = new BAsyncResultReceiveMethod<Integer>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setPartner(ClientIF client) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setPartner(client, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setPartner(ClientIF client, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_ServerIF_setPartner req = new BRequest_ServerIF_setPartner();		
		req.client = client;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public ClientIF getPartner() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<ClientIF> asyncResult = new BSyncResult<ClientIF>();		
		async_getPartner(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getPartner(final BAsyncResult<ClientIF> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_ServerIF_getPartner req = new BRequest_ServerIF_getPartner();		
		BAsyncResultReceiveMethod<ClientIF> outerResult = new BAsyncResultReceiveMethod<ClientIF>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.List<java.io.InputStream> getStreamsFromClient() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.List<java.io.InputStream>> asyncResult = new BSyncResult<java.util.List<java.io.InputStream>>();		
		async_getStreamsFromClient(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getStreamsFromClient(final BAsyncResult<java.util.List<java.io.InputStream>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_ServerIF_getStreamsFromClient req = new BRequest_ServerIF_getStreamsFromClient();		
		BAsyncResultReceiveMethod<java.util.List<java.io.InputStream>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.io.InputStream>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void putStreamsOnClient(java.util.List<java.io.InputStream> streams) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_putStreamsOnClient(streams, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_putStreamsOnClient(java.util.List<java.io.InputStream> streams, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_ServerIF_putStreamsOnClient req = new BRequest_ServerIF_putStreamsOnClient();		
		req.streams = streams;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void registerWithClientMap(int id) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_registerWithClientMap(id, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_registerWithClientMap(int id, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_ServerIF_registerWithClientMap req = new BRequest_ServerIF_registerWithClientMap();		
		req.id = id;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public ClientIF getClient(int id) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<ClientIF> asyncResult = new BSyncResult<ClientIF>();		
		async_getClient(id, asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getClient(int id, final BAsyncResult<ClientIF> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_ServerIF_getClient req = new BRequest_ServerIF_getClient();		
		req.id = id;
		BAsyncResultReceiveMethod<ClientIF> outerResult = new BAsyncResultReceiveMethod<ClientIF>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.Set<java.lang.Integer> getClientIds() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.Set<java.lang.Integer>> asyncResult = new BSyncResult<java.util.Set<java.lang.Integer>>();		
		async_getClientIds(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getClientIds(final BAsyncResult<java.util.Set<java.lang.Integer>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_ServerIF_getClientIds req = new BRequest_ServerIF_getClientIds();		
		BAsyncResultReceiveMethod<java.util.Set<java.lang.Integer>> outerResult = new BAsyncResultReceiveMethod<java.util.Set<java.lang.Integer>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public int callClientParallel(int v) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Integer> asyncResult = new BSyncResult<Integer>();		
		async_callClientParallel(v, asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_callClientParallel(int v, final BAsyncResult<Integer> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_ServerIF_callClientParallel req = new BRequest_ServerIF_callClientParallel();		
		req.v = v;
		BAsyncResultReceiveMethod<Integer> outerResult = new BAsyncResultReceiveMethod<Integer>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}
