//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes4dim_getChar : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 963726955; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:419
			try {
				RemoteArrayTypes4dim __byps__remoteT = (RemoteArrayTypes4dim)__byps__remote;				
				BAsyncResultSendMethod<char[,,,]> __byps__outerResult = new BAsyncResultSendMethod<char[,,,]>(__byps__asyncResult, new byps.test.api.BResult_769021986());				
				__byps__remoteT.GetChar(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1874279859L;		
	} // end class
}  // end namespace
