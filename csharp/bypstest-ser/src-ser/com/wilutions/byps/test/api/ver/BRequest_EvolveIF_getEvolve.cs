//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public sealed class BRequest_EvolveIF_getEvolve : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 2078696281; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				EvolveIF __byps__remoteT = (EvolveIF)__byps__remote;				
				BAsyncResultSendMethod<Evolve> __byps__outerResult = new BAsyncResultSendMethod<Evolve>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1391985860());				
				__byps__remoteT.async_GetEvolve(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 32041374L;		
	} // end class
}  // end namespace
