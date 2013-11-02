//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public sealed class BRequest_ServerIF_getClientIds : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1775199834; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:378
			try {
				ServerIF __byps__remoteT = (ServerIF)__byps__remote;				
				BAsyncResultSendMethod<ISet<int>> __byps__outerResult = new BAsyncResultSendMethod<ISet<int>>(__byps__asyncResult, new byps.test.api.BResult_1493282670());				
				__byps__remoteT.GetClientIds(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 2007476251L;		
	} // end class
}  // end namespace
