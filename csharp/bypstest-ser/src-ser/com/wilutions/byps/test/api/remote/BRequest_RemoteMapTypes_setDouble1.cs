//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteMapTypes_setDouble1 : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 80483097; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteMapTypes __byps__remoteT = (RemoteMapTypes)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_19());				
				__byps__remoteT.SetDouble1Async(_double1, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal IDictionary<byte,double> _double1;

		#endregion
		
		
		public static readonly long serialVersionUID = 99940797L;		
	} // end class
}  // end namespace
