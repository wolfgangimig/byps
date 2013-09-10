//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemotePrimitiveTypes_getChar : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1341983932; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemotePrimitiveTypes __byps__remoteT = (RemotePrimitiveTypes)__byps__remote;				
				BAsyncResultSendMethod<char> __byps__outerResult = new BAsyncResultSendMethod<char>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_4());				
				__byps__remoteT.async_GetChar(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(((char)0), e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 2091019842L;		
	} // end class
}  // end namespace
