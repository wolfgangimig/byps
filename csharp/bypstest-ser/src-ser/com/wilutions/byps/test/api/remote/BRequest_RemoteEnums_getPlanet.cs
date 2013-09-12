//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteEnums_getPlanet : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 359349400; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteEnums __byps__remoteT = (RemoteEnums)__byps__remote;				
				BAsyncResultSendMethod<com.wilutions.byps.test.api.enu.EnumPlanets> __byps__outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.enu.EnumPlanets>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1042475995());				
				__byps__remoteT.GetPlanetAsync(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(0, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 627010462L;		
	} // end class
}  // end namespace
