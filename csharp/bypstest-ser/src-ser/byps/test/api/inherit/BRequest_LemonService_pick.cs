﻿//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public sealed class BRequest_LemonService_pick : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 605543968; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:372
			try {
				LemonService __byps__remoteT = (LemonService)__byps__remote;				
				BAsyncResultSendMethod<String> __byps__outerResult = new BAsyncResultSendMethod<String>(__byps__asyncResult, new byps.test.api.BResult_10());				
				__byps__remoteT.Pick(_sess, _fromTree, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult("", e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal byps.test.api.auth.SessionInfo _sess;

		internal String _fromTree;

		#endregion
		
		
		public static readonly long serialVersionUID = 1022088379L;		
	} // end class
}  // end namespace