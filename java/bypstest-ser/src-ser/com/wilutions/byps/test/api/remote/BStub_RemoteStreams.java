﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenRemoteStub DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:159
public class BStub_RemoteStreams extends BStub implements RemoteStreamsAsync, java.io.Serializable {
	
	public final static long serialVersionUID = 0L;
	
	public BStub_RemoteStreams(final BTransport transport) {
		super(transport);		
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.io.InputStream getImage() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.io.InputStream> asyncResult = new BSyncResult<java.io.InputStream>();		
		async_getImage(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getImage(final BAsyncResult<java.io.InputStream> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteStreams_getImage req = new BRequest_RemoteStreams_getImage();		
		BAsyncResultReceiveMethod<java.io.InputStream> outerResult = new BAsyncResultReceiveMethod<java.io.InputStream>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setImage(java.io.InputStream istrm) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setImage(istrm, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setImage(java.io.InputStream istrm, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteStreams_setImage req = new BRequest_RemoteStreams_setImage();		
		req.istrm = istrm;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.util.TreeMap<java.lang.Integer,java.io.InputStream> getImages() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.util.TreeMap<java.lang.Integer,java.io.InputStream>> asyncResult = new BSyncResult<java.util.TreeMap<java.lang.Integer,java.io.InputStream>>();		
		async_getImages(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getImages(final BAsyncResult<java.util.TreeMap<java.lang.Integer,java.io.InputStream>> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteStreams_getImages req = new BRequest_RemoteStreams_getImages();		
		BAsyncResultReceiveMethod<java.util.TreeMap<java.lang.Integer,java.io.InputStream>> outerResult = new BAsyncResultReceiveMethod<java.util.TreeMap<java.lang.Integer,java.io.InputStream>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void setImages(java.util.Map<java.lang.Integer,java.io.InputStream> istrms, int doNotReadStreamAtKey) throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setImages(istrms, doNotReadStreamAtKey, asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_setImages(java.util.Map<java.lang.Integer,java.io.InputStream> istrms, int doNotReadStreamAtKey, final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteStreams_setImages req = new BRequest_RemoteStreams_setImages();		
		req.istrms = istrms;
		req.doNotReadStreamAtKey = doNotReadStreamAtKey;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public void throwLastException() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_throwLastException(asyncResult);
		asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_throwLastException(final BAsyncResult<Object> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteStreams_throwLastException req = new BRequest_RemoteStreams_throwLastException();		
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	// checkpoint com.wilutions.byps.gen.j.PrintContext:356
	public java.io.InputStream getTextStream() throws RemoteException {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:45
		final BSyncResult<java.io.InputStream> asyncResult = new BSyncResult<java.io.InputStream>();		
		async_getTextStream(asyncResult);
		return asyncResult.getResult();		
	}
	// checkpoint com.wilutions.byps.gen.j.PrintContext:400
	public void async_getTextStream(final BAsyncResult<java.io.InputStream> asyncResult) {
		// checkpoint com.wilutions.byps.gen.j.GenRemoteStub:110
		BRequest_RemoteStreams_getTextStream req = new BRequest_RemoteStreams_getTextStream();		
		BAsyncResultReceiveMethod<java.io.InputStream> outerResult = new BAsyncResultReceiveMethod<java.io.InputStream>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}
