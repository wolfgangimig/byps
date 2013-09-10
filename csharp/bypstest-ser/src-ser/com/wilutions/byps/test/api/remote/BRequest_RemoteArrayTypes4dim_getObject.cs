//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes4dim_getObject : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1557173854; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteArrayTypes4dim __byps__remoteT = (RemoteArrayTypes4dim)__byps__remote;				
				BAsyncResultSendMethod<Object[,,,]> __byps__outerResult = new BAsyncResultSendMethod<Object[,,,]>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_124584219());				
				__byps__remoteT.async_GetObject(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 278996403L;		
	} // end class
}  // end namespace
