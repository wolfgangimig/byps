//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public sealed class BRequest_ServerIF_getClient : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1775199834; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:372
			try {
				ServerIF __byps__remoteT = (ServerIF)__byps__remote;				
				BAsyncResultSendMethod<ClientIF> __byps__outerResult = new BAsyncResultSendMethod<ClientIF>(__byps__asyncResult, new byps.test.api.BResult_955752991());				
				__byps__remoteT.GetClient(_id, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int _id;

		#endregion
		
		
		public static readonly long serialVersionUID = 190669475L;		
	} // end class
}  // end namespace
