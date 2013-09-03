//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteWithAuthentication_setReloginCount : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 1677934392; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteWithAuthentication __byps__remoteT = (RemoteWithAuthentication)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_19());				
				__byps__remoteT.async_SetReloginCount(_count, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int _count;

		#endregion
		
		
		public static readonly long serialVersionUID = 20608797L;		
	} // end class
}  // end namespace
