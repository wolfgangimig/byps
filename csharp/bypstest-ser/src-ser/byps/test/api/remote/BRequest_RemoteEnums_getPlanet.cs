//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteEnums_getPlanet : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 485761455; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:378
			try {
				RemoteEnums __byps__remoteT = (RemoteEnums)__byps__remote;				
				BAsyncResultSendMethod<byps.test.api.enu.EnumPlanets> __byps__outerResult = new BAsyncResultSendMethod<byps.test.api.enu.EnumPlanets>(__byps__asyncResult, new byps.test.api.BResult_1375035164());				
				__byps__remoteT.GetPlanet(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(0, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 6352043L;		
	} // end class
}  // end namespace
