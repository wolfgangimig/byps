using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public interface RemoteServerCtrl : BRemote
	{
		void PublishRemote(String name, BRemote remote, bool fowardToOtherServers);
		void async_PublishRemote(String name, BRemote remote, bool fowardToOtherServers, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginPublishRemote(String name, BRemote remote, bool fowardToOtherServers, AsyncCallback callback, object state);
		Object EndPublishRemote(IAsyncResult asyncResult);
		
		BRemote GetPublishedRemote(String name);
		void async_GetPublishedRemote(String name, BAsyncResult<BRemote> asyncResult) ;
		IAsyncResult BeginGetPublishedRemote(String name, AsyncCallback callback, object state);
		BRemote EndGetPublishedRemote(IAsyncResult asyncResult);
		
		void RemovePublishedRemote(String name);
		void async_RemovePublishedRemote(String name, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginRemovePublishedRemote(String name, AsyncCallback callback, object state);
		Object EndRemovePublishedRemote(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
