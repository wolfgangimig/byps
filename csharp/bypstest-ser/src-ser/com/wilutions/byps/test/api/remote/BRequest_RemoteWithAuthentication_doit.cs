//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteWithAuthentication_doit : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1677934392; }
		
		// checkpoint com.wilutions.byps.gen.cs.GenApiClass:435
		public override void setSession(Object __byps__sess) {
			_sess = (com.wilutions.byps.test.api.auth.SessionInfo)__byps__sess;
		}
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint com.wilutions.byps.gen.cs.GenApiClass:372
			try {
				RemoteWithAuthentication __byps__remoteT = (RemoteWithAuthentication)__byps__remote;				
				BAsyncResultSendMethod<int> __byps__outerResult = new BAsyncResultSendMethod<int>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_5());				
				__byps__remoteT.Doit(_sess, _value, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(0, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal com.wilutions.byps.test.api.auth.SessionInfo _sess;

		internal int _value;

		#endregion
		
		
		public static readonly long serialVersionUID = 388793292L;		
	} // end class
}  // end namespace
