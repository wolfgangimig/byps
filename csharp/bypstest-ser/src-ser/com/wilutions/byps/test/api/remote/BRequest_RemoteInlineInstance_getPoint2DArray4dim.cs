//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteInlineInstance_getPoint2DArray4dim : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1206670536; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteInlineInstance __byps__remoteT = (RemoteInlineInstance)__byps__remote;				
				BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Point2D[,,,]> __byps__outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Point2D[,,,]>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_487702928());				
				__byps__remoteT.async_GetPoint2DArray4dim(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1012059475L;		
	} // end class
}  // end namespace
