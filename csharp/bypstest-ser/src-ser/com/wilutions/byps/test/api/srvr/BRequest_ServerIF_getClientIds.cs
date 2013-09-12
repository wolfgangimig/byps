//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public sealed class BRequest_ServerIF_getClientIds : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1313562065; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				ServerIF __byps__remoteT = (ServerIF)__byps__remote;				
				BAsyncResultSendMethod<ISet<int>> __byps__outerResult = new BAsyncResultSendMethod<ISet<int>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1493282670());				
				__byps__remoteT.GetClientIdsAsync(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 2063368540L;		
	} // end class
}  // end namespace
