//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemotePrimitiveTypes_getPrimitiveTypes : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1341983932; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint com.wilutions.byps.gen.cs.GenApiClass:372
			try {
				RemotePrimitiveTypes __byps__remoteT = (RemotePrimitiveTypes)__byps__remote;				
				BAsyncResultSendMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes> __byps__outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1000());				
				__byps__remoteT.GetPrimitiveTypes(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1881962430L;		
	} // end class
}  // end namespace
