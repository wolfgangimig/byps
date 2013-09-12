//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteSetTypes_getBoolean1 : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1156008353; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteSetTypes __byps__remoteT = (RemoteSetTypes)__byps__remote;				
				BAsyncResultSendMethod<ISet<bool>> __byps__outerResult = new BAsyncResultSendMethod<ISet<bool>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1365696060());				
				__byps__remoteT.GetBoolean1Async(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1690813926L;		
	} // end class
}  // end namespace
