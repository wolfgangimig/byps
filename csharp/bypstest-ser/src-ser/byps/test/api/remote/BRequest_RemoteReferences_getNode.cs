//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteReferences_getNode : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 568637225; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:413
			try {
				RemoteReferences __byps__remoteT = (RemoteReferences)__byps__remote;				
				BAsyncResultSendMethod<byps.test.api.refs.Node> __byps__outerResult = new BAsyncResultSendMethod<byps.test.api.refs.Node>(__byps__asyncResult, new byps.test.api.BResult_9001());				
				__byps__remoteT.GetNode(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1366991859L;		
	} // end class
}  // end namespace
