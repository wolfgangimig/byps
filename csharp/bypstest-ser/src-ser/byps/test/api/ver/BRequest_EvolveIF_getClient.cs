//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	public sealed class BRequest_EvolveIF_getClient : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 15377840; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				EvolveIF __byps__remoteT = (EvolveIF)__byps__remote;				
				BAsyncResultSendMethod<EvolveIF> __byps__outerResult = new BAsyncResultSendMethod<EvolveIF>(__byps__asyncResult, new byps.test.api.BResult_564008001());				
				__byps__remoteT.GetClient(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1212621223L;		
	} // end class
}  // end namespace
