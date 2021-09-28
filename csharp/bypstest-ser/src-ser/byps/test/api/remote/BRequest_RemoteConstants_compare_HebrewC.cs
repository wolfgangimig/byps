//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteConstants_compare_HebrewC : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 2045242510; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:419
			try {
				RemoteConstants __byps__remoteT = (RemoteConstants)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());				
				__byps__remoteT.Compare_HebrewC(ALEPHValue, BETHValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal byps.test.api.cons.HebrewZ ALEPHValue;

		internal byps.test.api.cons.HebrewZ BETHValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1711871378L;		
	} // end class
}  // end namespace
