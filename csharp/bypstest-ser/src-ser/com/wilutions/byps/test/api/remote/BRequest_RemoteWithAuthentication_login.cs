//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteWithAuthentication_login : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1677934392; }
		
		// checkpoint com.wilutions.byps.gen.cs.GenApiClass:433
		public override void setSession(Object __byps__sess) {
			_sess = (com.wilutions.byps.test.api.auth.SessionInfo)__byps__sess;
		}
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteWithAuthentication __byps__remoteT = (RemoteWithAuthentication)__byps__remote;				
				BAsyncResultSendMethod<com.wilutions.byps.test.api.auth.SessionInfo> __byps__outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.auth.SessionInfo>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_65775978());				
				__byps__remoteT.LoginAsync(_sess, _userName, _userPwd, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal com.wilutions.byps.test.api.auth.SessionInfo _sess;

		internal String _userName;

		internal String _userPwd;

		#endregion
		
		
		public static readonly long serialVersionUID = 839695851L;		
	} // end class
}  // end namespace
