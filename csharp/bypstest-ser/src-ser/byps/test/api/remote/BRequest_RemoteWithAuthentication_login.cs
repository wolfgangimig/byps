//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteWithAuthentication_login : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1983670399; }
		
		// checkpoint byps.gen.cs.GenApiClass:472
		public override void setSession(Object __byps__sess) {
			sessValue = (byps.test.api.auth.SessionInfo)__byps__sess;
		}
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				RemoteWithAuthentication __byps__remoteT = (RemoteWithAuthentication)__byps__remote;				
				BAsyncResultSendMethod<byps.test.api.auth.SessionInfo> __byps__outerResult = new BAsyncResultSendMethod<byps.test.api.auth.SessionInfo>(__byps__asyncResult, new byps.test.api.BResult_65775978());				
				__byps__remoteT.Login(sessValue, userNameValue, userPwdValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal byps.test.api.auth.SessionInfo sessValue;

		internal String userNameValue;

		internal String userPwdValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 134687724L;		
	} // end class
}  // end namespace
