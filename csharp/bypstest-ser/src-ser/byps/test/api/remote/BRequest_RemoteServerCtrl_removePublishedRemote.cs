//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteServerCtrl_removePublishedRemote : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1652234479; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:419
			try {
				RemoteServerCtrl __byps__remoteT = (RemoteServerCtrl)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());				
				__byps__remoteT.RemovePublishedRemote(nameValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal String nameValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 135366859L;		
	} // end class
}  // end namespace
