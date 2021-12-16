//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteMapTypes_getByte2 : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 664304990; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:420
			try {
				RemoteMapTypes __byps__remoteT = (RemoteMapTypes)__byps__remote;				
				BAsyncResultSendMethod<IDictionary<int,byte[]>> __byps__outerResult = new BAsyncResultSendMethod<IDictionary<int,byte[]>>(__byps__asyncResult, new byps.test.api.BResult_1799280818());				
				__byps__remoteT.GetByte2(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 124722646L;		
	} // end class
}  // end namespace
