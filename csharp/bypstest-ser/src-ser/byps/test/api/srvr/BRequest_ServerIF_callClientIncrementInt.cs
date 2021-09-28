//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public sealed class BRequest_ServerIF_callClientIncrementInt : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1775199834; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:419
			try {
				ServerIF __byps__remoteT = (ServerIF)__byps__remote;				
				BAsyncResultSendMethod<int> __byps__outerResult = new BAsyncResultSendMethod<int>(__byps__asyncResult, new byps.test.api.BResult_5());				
				__byps__remoteT.CallClientIncrementInt(vValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(0, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int vValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 389860173L;		
	} // end class
}  // end namespace
