//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes4dim_getDouble : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 1557173854; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteArrayTypes4dim __byps__remoteT = (RemoteArrayTypes4dim)__byps__remote;				
				BAsyncResultSendMethod<double[,,,]> __byps__outerResult = new BAsyncResultSendMethod<double[,,,]>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_2087445849());				
				__byps__remoteT.async_GetDouble(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 581586209L;		
	} // end class
}  // end namespace
