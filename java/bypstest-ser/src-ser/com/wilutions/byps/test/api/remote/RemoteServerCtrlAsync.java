package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public interface RemoteServerCtrlAsync extends RemoteServerCtrl, BRemote {

	public void async_publishRemote(java.lang.String name, BRemote remote, boolean fowardToOtherServers, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getPublishedRemote(java.lang.String name, final BAsyncResult<BRemote> asyncResult) ;
	
	public void async_removePublishedRemote(java.lang.String name, final BAsyncResult<Object> asyncResult) ;
	
	
}
