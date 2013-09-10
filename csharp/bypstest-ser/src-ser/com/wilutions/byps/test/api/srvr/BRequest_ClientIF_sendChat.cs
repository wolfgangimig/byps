//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public sealed class BRequest_ClientIF_sendChat : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1784257353; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				ClientIF __byps__remoteT = (ClientIF)__byps__remote;				
				BAsyncResultSendMethod<ChatStructure> __byps__outerResult = new BAsyncResultSendMethod<ChatStructure>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_7007());				
				__byps__remoteT.async_SendChat(_cs, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal ChatStructure _cs;

		#endregion
		
		
		public static readonly long serialVersionUID = 1352392091L;		
	} // end class
}  // end namespace
