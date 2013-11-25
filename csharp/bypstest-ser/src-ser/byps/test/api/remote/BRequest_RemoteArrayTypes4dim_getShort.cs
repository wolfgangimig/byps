//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes4dim_getShort : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1176051258; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				RemoteArrayTypes4dim __byps__remoteT = (RemoteArrayTypes4dim)__byps__remote;				
				BAsyncResultSendMethod<short[,,,]> __byps__outerResult = new BAsyncResultSendMethod<short[,,,]>(__byps__asyncResult, new byps.test.api.BResult_1859644668());				
				__byps__remoteT.GetShort(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 2041656421L;		
	} // end class
}  // end namespace
