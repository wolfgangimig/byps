using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteReferences : BRemote {
	
		byps.test.api.refs.Node GetNode();
		void GetNode(BAsyncResult<byps.test.api.refs.Node> asyncResult) ;
		Task<byps.test.api.refs.Node> GetNodeAsync();
		
		void SetNode(byps.test.api.refs.Node v);
		void SetNode(byps.test.api.refs.Node v, BAsyncResult<Object> asyncResult) ;
		Task SetNodeAsync(byps.test.api.refs.Node v);
		
		
	}
}  // end namespace
