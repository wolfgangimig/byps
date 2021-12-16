//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteWithAuthentication_doit : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1983670399; }
		
		// checkpoint byps.gen.cs.GenApiClass:486
		public override void setSession(Object __byps__sess) {
			sessValue = (byps.test.api.auth.SessionInfo)__byps__sess;
		}
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:420
			try {
				RemoteWithAuthentication __byps__remoteT = (RemoteWithAuthentication)__byps__remote;				
				BAsyncResultSendMethod<int> __byps__outerResult = new BAsyncResultSendMethod<int>(__byps__asyncResult, new byps.test.api.BResult_5());				
				__byps__remoteT.Doit(sessValue, valueValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(0, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal byps.test.api.auth.SessionInfo sessValue;

		internal int valueValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1251509013L;		
	} // end class
}  // end namespace
