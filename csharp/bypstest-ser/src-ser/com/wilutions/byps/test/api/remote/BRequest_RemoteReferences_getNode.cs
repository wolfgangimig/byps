//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteReferences_getNode : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 2086824050; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteReferences __byps__remoteT = (RemoteReferences)__byps__remote;				
				BAsyncResultSendMethod<com.wilutions.byps.test.api.refs.Node> __byps__outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.refs.Node>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_9001());				
				__byps__remoteT.async_GetNode(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 655936732L;		
	} // end class
}  // end namespace
