//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public sealed class BRequest_ClientIF_getStreams : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 2049072174; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				ClientIF __byps__remoteT = (ClientIF)__byps__remote;				
				BAsyncResultSendMethod<IList<System.IO.Stream>> __byps__outerResult = new BAsyncResultSendMethod<IList<System.IO.Stream>>(__byps__asyncResult, new byps.test.api.BResult_1218831438());				
				__byps__remoteT.GetStreams(ctrlValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int ctrlValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1654980071L;		
	} // end class
}  // end namespace
