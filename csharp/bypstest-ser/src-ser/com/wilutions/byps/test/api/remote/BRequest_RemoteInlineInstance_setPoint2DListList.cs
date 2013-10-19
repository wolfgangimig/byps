//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteInlineInstance_setPoint2DListList : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1206670536; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint com.wilutions.byps.gen.cs.GenApiClass:372
			try {
				RemoteInlineInstance __byps__remoteT = (RemoteInlineInstance)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_19());				
				__byps__remoteT.SetPoint2DListList(_pointListList, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal IList<IList<com.wilutions.byps.test.api.inl.Point2D>> _pointListList;

		#endregion
		
		
		public static readonly long serialVersionUID = 1097161578L;		
	} // end class
}  // end namespace
