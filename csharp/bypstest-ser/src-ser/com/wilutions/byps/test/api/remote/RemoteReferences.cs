using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public interface RemoteReferences : BRemote
	{
		com.wilutions.byps.test.api.refs.Node GetNode();
		void async_GetNode(BAsyncResult<com.wilutions.byps.test.api.refs.Node> asyncResult) ;
		IAsyncResult BeginGetNode(AsyncCallback callback, object state);
		com.wilutions.byps.test.api.refs.Node EndGetNode(IAsyncResult asyncResult);
		
		void SetNode(com.wilutions.byps.test.api.refs.Node v);
		void async_SetNode(com.wilutions.byps.test.api.refs.Node v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetNode(com.wilutions.byps.test.api.refs.Node v, AsyncCallback callback, object state);
		Object EndSetNode(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
