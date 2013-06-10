package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public interface ClientIFAsync extends ClientIF, BRemote {

	public void async_incrementInt(int a, final BAsyncResult<Integer> asyncResult) ;
	
	public void async_getStreams(int ctrl, final BAsyncResult<java.util.List<java.io.InputStream>> asyncResult) ;
	
	public void async_putStreams(java.util.List<java.io.InputStream> strm, int ctrl, final BAsyncResult<Object> asyncResult) ;
	
	public void async_sendChat(ChatStructure cs, final BAsyncResult<ChatStructure> asyncResult) ;
	
	
}
