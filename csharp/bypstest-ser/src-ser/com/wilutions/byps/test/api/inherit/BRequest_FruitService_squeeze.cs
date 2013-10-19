//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public sealed class BRequest_FruitService_squeeze : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 506940662; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint com.wilutions.byps.gen.cs.GenApiClass:372
			try {
				FruitService __byps__remoteT = (FruitService)__byps__remote;				
				BAsyncResultSendMethod<String> __byps__outerResult = new BAsyncResultSendMethod<String>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_10());				
				__byps__remoteT.Squeeze(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult("", e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 656804784L;		
	} // end class
}  // end namespace
