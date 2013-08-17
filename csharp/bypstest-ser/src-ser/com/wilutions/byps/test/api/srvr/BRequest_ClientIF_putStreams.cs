//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public sealed class BRequest_ClientIF_putStreams : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 1784257353; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				ClientIF __byps__remoteT = (ClientIF)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_19());				
				__byps__remoteT.async_PutStreams(_strm, _ctrl, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal IList<System.IO.Stream> _strm;

		internal int _ctrl;

		#endregion
		
		
		public static readonly long serialVersionUID = 242798857L;		
	} // end class
}  // end namespace
