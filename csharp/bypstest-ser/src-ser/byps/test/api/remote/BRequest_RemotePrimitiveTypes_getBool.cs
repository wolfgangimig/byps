//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemotePrimitiveTypes_getBool : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 456456; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				RemotePrimitiveTypes __byps__remoteT = (RemotePrimitiveTypes)__byps__remote;				
				BAsyncResultSendMethod<bool> __byps__outerResult = new BAsyncResultSendMethod<bool>(__byps__asyncResult, new byps.test.api.BResult_1());				
				__byps__remoteT.GetBool(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(false, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1816157633L;		
	} // end class
}  // end namespace
