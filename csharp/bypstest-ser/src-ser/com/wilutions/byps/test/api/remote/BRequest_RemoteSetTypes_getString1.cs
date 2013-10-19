//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteSetTypes_getString1 : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1156008353; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint com.wilutions.byps.gen.cs.GenApiClass:372
			try {
				RemoteSetTypes __byps__remoteT = (RemoteSetTypes)__byps__remote;				
				BAsyncResultSendMethod<ISet<String>> __byps__outerResult = new BAsyncResultSendMethod<ISet<String>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1888799711());				
				__byps__remoteT.GetString1(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 615539953L;		
	} // end class
}  // end namespace
