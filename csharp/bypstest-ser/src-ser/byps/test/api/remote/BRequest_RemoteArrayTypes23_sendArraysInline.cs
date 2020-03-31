//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes23_sendArraysInline : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 769717182; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:413
			try {
				RemoteArrayTypes23 __byps__remoteT = (RemoteArrayTypes23)__byps__remote;				
				BAsyncResultSendMethod<byps.test.api.inl.Point2D[]> __byps__outerResult = new BAsyncResultSendMethod<byps.test.api.inl.Point2D[]>(__byps__asyncResult, new byps.test.api.BResult_184101377());				
				__byps__remoteT.SendArraysInline(arr2Value, arr3Value, arr4Value, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal byps.test.api.inl.Point2D[,] arr2Value;

		internal byps.test.api.inl.Point2D[,,] arr3Value;

		internal byps.test.api.inl.Point2D[,,,] arr4Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 1467243283L;		
	} // end class
}  // end namespace
