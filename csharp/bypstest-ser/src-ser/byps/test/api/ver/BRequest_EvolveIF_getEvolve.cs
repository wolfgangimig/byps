//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	public sealed class BRequest_EvolveIF_getEvolve : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 15377840; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:372
			try {
				EvolveIF __byps__remoteT = (EvolveIF)__byps__remote;				
				BAsyncResultSendMethod<Evolve> __byps__outerResult = new BAsyncResultSendMethod<Evolve>(__byps__asyncResult, new byps.test.api.BResult_1391985860());				
				__byps__remoteT.GetEvolve(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 1279300441L;		
	} // end class
}  // end namespace
