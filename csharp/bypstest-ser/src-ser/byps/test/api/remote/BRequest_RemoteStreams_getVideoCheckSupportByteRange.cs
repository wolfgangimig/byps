//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteStreams_getVideoCheckSupportByteRange : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1043578866; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:420
			try {
				RemoteStreams __byps__remoteT = (RemoteStreams)__byps__remote;				
				BAsyncResultSendMethod<System.IO.Stream> __byps__outerResult = new BAsyncResultSendMethod<System.IO.Stream>(__byps__asyncResult, new byps.test.api.BResult_15());				
				__byps__remoteT.GetVideoCheckSupportByteRange(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1006919505L;		
	} // end class
}  // end namespace
