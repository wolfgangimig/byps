//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public sealed class BRequest_EvolveIF_getClient : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 2078696281; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				EvolveIF __byps__remoteT = (EvolveIF)__byps__remote;				
				BAsyncResultSendMethod<EvolveIF> __byps__outerResult = new BAsyncResultSendMethod<EvolveIF>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1178379224());				
				__byps__remoteT.async_GetClient(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 98720592L;		
	} // end class
}  // end namespace
