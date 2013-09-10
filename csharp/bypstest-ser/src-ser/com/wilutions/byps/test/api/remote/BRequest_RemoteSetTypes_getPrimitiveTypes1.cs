//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteSetTypes_getPrimitiveTypes1 : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1156008353; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteSetTypes __byps__remoteT = (RemoteSetTypes)__byps__remote;				
				BAsyncResultSendMethod<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> __byps__outerResult = new BAsyncResultSendMethod<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1280571537());				
				__byps__remoteT.async_GetPrimitiveTypes1(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1802821742L;		
	} // end class
}  // end namespace
