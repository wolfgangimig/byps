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
		
		public override int getRemoteId() { return 964138163; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				RemoteArrayTypes23 __byps__remoteT = (RemoteArrayTypes23)__byps__remote;				
				BAsyncResultSendMethod<byps.test.api.prim.PrimitiveTypes[]> __byps__outerResult = new BAsyncResultSendMethod<byps.test.api.prim.PrimitiveTypes[]>(__byps__asyncResult, new byps.test.api.BResult_2053507648());				
				__byps__remoteT.SendArraysClass(arr2Value, arr3Value, arr4Value, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal byps.test.api.prim.PrimitiveTypes[,] arr2Value;

		internal byps.test.api.prim.PrimitiveTypes[,,] arr3Value;

		internal byps.test.api.prim.PrimitiveTypes[,,,] arr4Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 330036060L;		
	} // end class
}  // end namespace
