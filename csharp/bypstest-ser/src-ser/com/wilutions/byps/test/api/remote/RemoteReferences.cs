using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface RemoteReferences : BRemote {
	
		com.wilutions.byps.test.api.refs.Node GetNode();
		void GetNode(BAsyncResult<com.wilutions.byps.test.api.refs.Node> asyncResult) ;
		Task<com.wilutions.byps.test.api.refs.Node> GetNodeAsync();
		
		void SetNode(com.wilutions.byps.test.api.refs.Node v);
		void SetNode(com.wilutions.byps.test.api.refs.Node v, BAsyncResult<Object> asyncResult) ;
		Task SetNodeAsync(com.wilutions.byps.test.api.refs.Node v);
		
		
	}
}  // end namespace
