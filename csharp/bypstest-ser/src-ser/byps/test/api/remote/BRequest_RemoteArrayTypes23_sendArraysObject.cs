//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes23_sendArraysObject : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 769717182; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:372
			try {
				RemoteArrayTypes23 __byps__remoteT = (RemoteArrayTypes23)__byps__remote;				
				BAsyncResultSendMethod<Object[]> __byps__outerResult = new BAsyncResultSendMethod<Object[]>(__byps__asyncResult, new byps.test.api.BResult_183594037());				
				__byps__remoteT.SendArraysObject(_arr2, _arr3, _arr4, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal Object[,] _arr2;

		internal Object[,,] _arr3;

		internal Object[,,,] _arr4;

		#endregion
		
		
		public static readonly long serialVersionUID = 1306614381L;		
	} // end class
}  // end namespace
