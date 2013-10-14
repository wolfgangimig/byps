//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public sealed class BRequest_BioFruitService_certify : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1881829396; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				BioFruitService __byps__remoteT = (BioFruitService)__byps__remote;				
				BAsyncResultSendMethod<bool> __byps__outerResult = new BAsyncResultSendMethod<bool>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1());				
				__byps__remoteT.CertifyAsync(_param, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(false, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal String _param;

		#endregion
		
		
		public static readonly long serialVersionUID = 724361898L;		
	} // end class
}  // end namespace
