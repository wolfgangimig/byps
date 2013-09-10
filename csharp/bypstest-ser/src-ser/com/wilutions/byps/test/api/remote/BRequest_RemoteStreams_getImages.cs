//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteStreams_getImages : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 2028487863; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteStreams __byps__remoteT = (RemoteStreams)__byps__remote;				
				BAsyncResultSendMethod<Dictionary<int,System.IO.Stream>> __byps__outerResult = new BAsyncResultSendMethod<Dictionary<int,System.IO.Stream>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_476459792());				
				__byps__remoteT.async_GetImages(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1158979935L;		
	} // end class
}  // end namespace
