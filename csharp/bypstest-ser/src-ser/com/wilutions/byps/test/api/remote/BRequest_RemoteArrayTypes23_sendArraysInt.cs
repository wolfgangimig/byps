//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes23_sendArraysInt : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 2081058997; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteArrayTypes23 __byps__remoteT = (RemoteArrayTypes23)__byps__remote;				
				BAsyncResultSendMethod<int[]> __byps__outerResult = new BAsyncResultSendMethod<int[]>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_100361105());				
				__byps__remoteT.SendArraysIntAsync(_arr2, _arr3, _arr4, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int[,] _arr2;

		internal int[,,] _arr3;

		internal int[,,,] _arr4;

		#endregion
		
		
		public static readonly long serialVersionUID = 1748523470L;		
	} // end class
}  // end namespace
