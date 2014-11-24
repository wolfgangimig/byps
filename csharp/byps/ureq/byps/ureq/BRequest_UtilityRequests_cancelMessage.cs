//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public sealed class BRequest_UtilityRequests_cancelMessage : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 363558736; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				UtilityRequests __byps__remoteT = (UtilityRequests)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new BResult_19());				
				__byps__remoteT.CancelMessage(messageIdValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal long messageIdValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 648161469L;		
	} // end class
}  // end namespace
