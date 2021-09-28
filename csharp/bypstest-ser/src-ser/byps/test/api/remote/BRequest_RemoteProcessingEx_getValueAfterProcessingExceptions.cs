//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 790485113; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:419
			try {
				RemoteProcessingEx __byps__remoteT = (RemoteProcessingEx)__byps__remote;				
				BAsyncResultSendMethod<bool> __byps__outerResult = new BAsyncResultSendMethod<bool>(__byps__asyncResult, new byps.test.api.BResult_1());				
				__byps__remoteT.GetValueAfterProcessingExceptions(sleepSecondsValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(false, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int sleepSecondsValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1155485035L;		
	} // end class
}  // end namespace
