//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemotePrimitiveTypes_add : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1341983932; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemotePrimitiveTypes __byps__remoteT = (RemotePrimitiveTypes)__byps__remote;				
				BAsyncResultSendMethod<int> __byps__outerResult = new BAsyncResultSendMethod<int>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_5());				
				__byps__remoteT.AddAsync(_a, _b, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(0, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int _a;

		internal int _b;

		#endregion
		
		
		public static readonly long serialVersionUID = 1073583639L;		
	} // end class
}  // end namespace
