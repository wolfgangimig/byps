//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public sealed class BRequest_BUtilityRequests_testAdapter : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 174367442; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				BUtilityRequests __byps__remoteT = (BUtilityRequests)__byps__remote;				
				BAsyncResultSendMethod<IDictionary<String,String>> __byps__outerResult = new BAsyncResultSendMethod<IDictionary<String,String>>(__byps__asyncResult, new BResult_1710660846());				
				__byps__remoteT.TestAdapter(functionNameValue, paramsValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal String functionNameValue;

		internal IDictionary<String,String> paramsValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 421787891L;		
	} // end class
}  // end namespace
