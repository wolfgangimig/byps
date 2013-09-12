//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes1dim_getBool : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1557084481; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteArrayTypes1dim __byps__remoteT = (RemoteArrayTypes1dim)__byps__remote;				
				BAsyncResultSendMethod<bool[]> __byps__outerResult = new BAsyncResultSendMethod<bool[]>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_2058423690());				
				__byps__remoteT.GetBoolAsync(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1645604187L;		
	} // end class
}  // end namespace
