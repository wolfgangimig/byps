package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class BStub_ClientIF extends BStub implements ClientIF, java.io.Serializable {
	
	public final static long serialVersionUID = 1784257353L;
	
	public BStub_ClientIF(final BTransport transport) {
		super(transport);		
	}
	
	public int incrementInt(int a) throws BException, InterruptedException {
		final BSyncResult<Integer> asyncResult = new BSyncResult<Integer>();		
		async_incrementInt(a, asyncResult);
		return asyncResult.getResult();		
	}
	public void async_incrementInt(int a, final BAsyncResult<Integer> asyncResult) {
		BRequest_ClientIF_incrementInt req = new BRequest_ClientIF_incrementInt();		
		req.a = a;
		BAsyncResultReceiveMethod<Integer> outerResult = new BAsyncResultReceiveMethod<Integer>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public java.util.List<java.io.InputStream> getStreams(int ctrl) throws BException, InterruptedException {
		final BSyncResult<java.util.List<java.io.InputStream>> asyncResult = new BSyncResult<java.util.List<java.io.InputStream>>();		
		async_getStreams(ctrl, asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getStreams(int ctrl, final BAsyncResult<java.util.List<java.io.InputStream>> asyncResult) {
		BRequest_ClientIF_getStreams req = new BRequest_ClientIF_getStreams();		
		req.ctrl = ctrl;
		BAsyncResultReceiveMethod<java.util.List<java.io.InputStream>> outerResult = new BAsyncResultReceiveMethod<java.util.List<java.io.InputStream>>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void putStreams(java.util.List<java.io.InputStream> strm, int ctrl) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_putStreams(strm, ctrl, asyncResult);
		asyncResult.getResult();		
	}
	public void async_putStreams(java.util.List<java.io.InputStream> strm, int ctrl, final BAsyncResult<Object> asyncResult) {
		BRequest_ClientIF_putStreams req = new BRequest_ClientIF_putStreams();		
		req.strm = strm;
		req.ctrl = ctrl;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public ChatStructure sendChat(ChatStructure cs) throws BException, InterruptedException {
		final BSyncResult<ChatStructure> asyncResult = new BSyncResult<ChatStructure>();		
		async_sendChat(cs, asyncResult);
		return asyncResult.getResult();		
	}
	public void async_sendChat(ChatStructure cs, final BAsyncResult<ChatStructure> asyncResult) {
		BRequest_ClientIF_sendChat req = new BRequest_ClientIF_sendChat();		
		req.cs = cs;
		BAsyncResultReceiveMethod<ChatStructure> outerResult = new BAsyncResultReceiveMethod<ChatStructure>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}
