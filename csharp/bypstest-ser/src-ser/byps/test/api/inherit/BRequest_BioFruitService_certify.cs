//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public sealed class BRequest_BioFruitService_certify : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 363642571; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				BioFruitService __byps__remoteT = (BioFruitService)__byps__remote;				
				BAsyncResultSendMethod<bool> __byps__outerResult = new BAsyncResultSendMethod<bool>(__byps__asyncResult, new byps.test.api.BResult_1());				
				__byps__remoteT.Certify(paramValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(false, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal String paramValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1435417025L;		
	} // end class
}  // end namespace
