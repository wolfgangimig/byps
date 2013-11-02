//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes23_sendArraysClass : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 769717182; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:378
			try {
				RemoteArrayTypes23 __byps__remoteT = (RemoteArrayTypes23)__byps__remote;				
				BAsyncResultSendMethod<byps.test.api.prim.PrimitiveTypes[]> __byps__outerResult = new BAsyncResultSendMethod<byps.test.api.prim.PrimitiveTypes[]>(__byps__asyncResult, new byps.test.api.BResult_2053507648());				
				__byps__remoteT.SendArraysClass(_arr2, _arr3, _arr4, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal byps.test.api.prim.PrimitiveTypes[,] _arr2;

		internal byps.test.api.prim.PrimitiveTypes[,,] _arr3;

		internal byps.test.api.prim.PrimitiveTypes[,,,] _arr4;

		#endregion
		
		
		public static readonly long serialVersionUID = 330036060L;		
	} // end class
}  // end namespace
