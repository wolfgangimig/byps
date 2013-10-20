//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public sealed class BRequest_LemonService_pick : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 617356599; }
		
		// checkpoint com.wilutions.byps.gen.cs.GenApiClass:435
		public override void setSession(Object __byps__sess) {
			_sess = (com.wilutions.byps.test.api.auth.SessionInfo)__byps__sess;
		}
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint com.wilutions.byps.gen.cs.GenApiClass:372
			try {
				LemonService __byps__remoteT = (LemonService)__byps__remote;				
				BAsyncResultSendMethod<String> __byps__outerResult = new BAsyncResultSendMethod<String>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_10());				
				__byps__remoteT.Pick(_sess, _fromTree, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult("", e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal com.wilutions.byps.test.api.auth.SessionInfo _sess;

		internal String _fromTree;

		#endregion
		
		
		public static readonly long serialVersionUID = 1860602130L;		
	} // end class
}  // end namespace
