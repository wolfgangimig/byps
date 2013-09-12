//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public sealed class BRequest_ClientIF_incrementInt : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1784257353; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				ClientIF __byps__remoteT = (ClientIF)__byps__remote;				
				BAsyncResultSendMethod<int> __byps__outerResult = new BAsyncResultSendMethod<int>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_5());				
				__byps__remoteT.IncrementIntAsync(_a, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(0, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int _a;

		#endregion
		
		
		public static readonly long serialVersionUID = 1461829915L;		
	} // end class
}  // end namespace
