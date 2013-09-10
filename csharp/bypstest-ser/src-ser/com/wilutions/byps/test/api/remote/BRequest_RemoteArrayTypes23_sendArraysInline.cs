//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes23_sendArraysInline : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 2081058997; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteArrayTypes23 __byps__remoteT = (RemoteArrayTypes23)__byps__remote;				
				BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Point2D[]> __byps__outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Point2D[]>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_2049740106());				
				__byps__remoteT.async_SendArraysInline(_arr2, _arr3, _arr4, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal com.wilutions.byps.test.api.inl.Point2D[,] _arr2;

		internal com.wilutions.byps.test.api.inl.Point2D[,,] _arr3;

		internal com.wilutions.byps.test.api.inl.Point2D[,,,] _arr4;

		#endregion
		
		
		public static readonly long serialVersionUID = 899462794L;		
	} // end class
}  // end namespace
