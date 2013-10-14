using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:81
	public interface RemoteServerCtrl : BRemote {
	
		void PublishRemote(String name, BRemote remote, bool fowardToOtherServers);
		void PublishRemoteAsync(String name, BRemote remote, bool fowardToOtherServers, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginPublishRemote(String name, BRemote remote, bool fowardToOtherServers, AsyncCallback callback, object state);
		Object EndPublishRemote(IAsyncResult asyncResult);
		
		BRemote GetPublishedRemote(String name);
		void GetPublishedRemoteAsync(String name, BAsyncResult<BRemote> asyncResult) ;
		IAsyncResult BeginGetPublishedRemote(String name, AsyncCallback callback, object state);
		BRemote EndGetPublishedRemote(IAsyncResult asyncResult);
		
		void RemovePublishedRemote(String name);
		void RemovePublishedRemoteAsync(String name, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginRemovePublishedRemote(String name, AsyncCallback callback, object state);
		Object EndRemovePublishedRemote(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
