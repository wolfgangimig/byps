//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes4dim_setShort : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1176051258; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				RemoteArrayTypes4dim __byps__remoteT = (RemoteArrayTypes4dim)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());				
				__byps__remoteT.SetShort(vValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal short[,,,] vValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1480543961L;		
	} // end class
}  // end namespace
