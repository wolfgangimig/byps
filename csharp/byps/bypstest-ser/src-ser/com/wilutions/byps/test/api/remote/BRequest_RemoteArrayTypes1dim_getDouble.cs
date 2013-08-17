//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes1dim_getDouble : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 1557084481; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteArrayTypes1dim __byps__remoteT = (RemoteArrayTypes1dim)__byps__remote;				
				BAsyncResultSendMethod<double[]> __byps__outerResult = new BAsyncResultSendMethod<double[]>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1359468275());				
				__byps__remoteT.async_GetDouble(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 935089666L;		
	} // end class
}  // end namespace
