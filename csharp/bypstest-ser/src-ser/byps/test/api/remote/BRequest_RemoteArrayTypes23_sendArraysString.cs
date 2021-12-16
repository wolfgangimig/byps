//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes23_sendArraysString : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 769717182; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:420
			try {
				RemoteArrayTypes23 __byps__remoteT = (RemoteArrayTypes23)__byps__remote;				
				BAsyncResultSendMethod<String[]> __byps__outerResult = new BAsyncResultSendMethod<String[]>(__byps__asyncResult, new byps.test.api.BResult_1888107655());				
				__byps__remoteT.SendArraysString(arr2Value, arr3Value, arr4Value, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal String[,] arr2Value;

		internal String[,,] arr3Value;

		internal String[,,,] arr4Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 1175231899L;		
	} // end class
}  // end namespace
