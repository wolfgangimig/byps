//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteMapTypes_getPrimitiveTypes1 : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 664304990; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:429
			try {
				RemoteMapTypes __byps__remoteT = (RemoteMapTypes)__byps__remote;				
				BAsyncResultSendMethod<IDictionary<int,byps.test.api.prim.PrimitiveTypes>> __byps__outerResult = new BAsyncResultSendMethod<IDictionary<int,byps.test.api.prim.PrimitiveTypes>>(__byps__asyncResult, new byps.test.api.BResult_1831201218());				
				__byps__remoteT.GetPrimitiveTypes1(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1745799327L;		
	} // end class
}  // end namespace
