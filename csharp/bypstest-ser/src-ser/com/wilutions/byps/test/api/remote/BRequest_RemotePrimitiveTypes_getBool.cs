//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemotePrimitiveTypes_getBool : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 1341983932; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemotePrimitiveTypes __byps__remoteT = (RemotePrimitiveTypes)__byps__remote;				
				BAsyncResultSendMethod<bool> __byps__outerResult = new BAsyncResultSendMethod<bool>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1());				
				__byps__remoteT.async_GetBool(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(false, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 2090997206L;		
	} // end class
}  // end namespace
