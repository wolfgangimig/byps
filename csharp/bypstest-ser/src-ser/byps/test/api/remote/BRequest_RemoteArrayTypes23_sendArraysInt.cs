//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes23_sendArraysInt : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 769717182; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:429
			try {
				RemoteArrayTypes23 __byps__remoteT = (RemoteArrayTypes23)__byps__remote;				
				BAsyncResultSendMethod<int[]> __byps__outerResult = new BAsyncResultSendMethod<int[]>(__byps__asyncResult, new byps.test.api.BResult_100361105());				
				__byps__remoteT.SendArraysInt(arr2Value, arr3Value, arr4Value, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int[,] arr2Value;

		internal int[,,] arr3Value;

		internal int[,,,] arr4Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 1828268517L;		
	} // end class
}  // end namespace
