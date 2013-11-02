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
			// checkpoint byps.gen.cs.GenApiClass:378
			try {
				RemoteArrayTypes23 __byps__remoteT = (RemoteArrayTypes23)__byps__remote;				
				BAsyncResultSendMethod<String[]> __byps__outerResult = new BAsyncResultSendMethod<String[]>(__byps__asyncResult, new byps.test.api.BResult_1888107655());				
				__byps__remoteT.SendArraysString(_arr2, _arr3, _arr4, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal String[,] _arr2;

		internal String[,,] _arr3;

		internal String[,,,] _arr4;

		#endregion
		
		
		public static readonly long serialVersionUID = 1175231899L;		
	} // end class
}  // end namespace
