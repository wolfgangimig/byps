﻿//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteArrayTypes1dim_getChar : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 123123; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:419
			try {
				RemoteArrayTypes1dim __byps__remoteT = (RemoteArrayTypes1dim)__byps__remote;				
				BAsyncResultSendMethod<char[]> __byps__outerResult = new BAsyncResultSendMethod<char[]>(__byps__asyncResult, new byps.test.api.BResult_1361632968());				
				__byps__remoteT.GetChar(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 2033439280L;		
	} // end class
}  // end namespace
