//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteServerCtrl_publishRemote : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 2037577312; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				RemoteServerCtrl __byps__remoteT = (RemoteServerCtrl)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());				
				__byps__remoteT.PublishRemote(nameValue, remoteValue, fowardToOtherServersValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal String nameValue;

		internal BRemote remoteValue;

		internal bool fowardToOtherServersValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1543768912L;		
	} // end class
}  // end namespace
