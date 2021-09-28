//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public sealed class BRequest_ClientIF_sendChat : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 2049072174; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:419
			try {
				ClientIF __byps__remoteT = (ClientIF)__byps__remote;				
				BAsyncResultSendMethod<ChatStructure> __byps__outerResult = new BAsyncResultSendMethod<ChatStructure>(__byps__asyncResult, new byps.test.api.BResult_7007());				
				__byps__remoteT.SendChat(csValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal ChatStructure csValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 41050276L;		
	} // end class
}  // end namespace
