//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public sealed class BRequest_ClientIF_getStreams : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1784257353; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				ClientIF __byps__remoteT = (ClientIF)__byps__remote;				
				BAsyncResultSendMethod<IList<System.IO.Stream>> __byps__outerResult = new BAsyncResultSendMethod<IList<System.IO.Stream>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1218831438());				
				__byps__remoteT.async_GetStreams(_ctrl, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int _ctrl;

		#endregion
		
		
		public static readonly long serialVersionUID = 865920738L;		
	} // end class
}  // end namespace
