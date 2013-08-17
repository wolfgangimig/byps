//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public sealed class BRequest_ServerIF_callClientIncrementInt : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 1313562065; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				ServerIF __byps__remoteT = (ServerIF)__byps__remote;				
				BAsyncResultSendMethod<int> __byps__outerResult = new BAsyncResultSendMethod<int>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_5());				
				__byps__remoteT.async_CallClientIncrementInt(_v, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(0, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int _v;

		#endregion
		
		
		public static readonly long serialVersionUID = 1252575894L;		
	} // end class
}  // end namespace
