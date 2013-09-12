//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteInlineInstance_getPoint2DListList : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1206670536; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteInlineInstance __byps__remoteT = (RemoteInlineInstance)__byps__remote;				
				BAsyncResultSendMethod<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>> __byps__outerResult = new BAsyncResultSendMethod<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1463615848());				
				__byps__remoteT.GetPoint2DListListAsync(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 177127926L;		
	} // end class
}  // end namespace
