//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteSetTypes_getDouble1 : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1900796440; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:419
			try {
				RemoteSetTypes __byps__remoteT = (RemoteSetTypes)__byps__remote;				
				BAsyncResultSendMethod<ISet<double>> __byps__outerResult = new BAsyncResultSendMethod<ISet<double>>(__byps__asyncResult, new byps.test.api.BResult_1320560671());				
				__byps__remoteT.GetDouble1(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1751651450L;		
	} // end class
}  // end namespace
