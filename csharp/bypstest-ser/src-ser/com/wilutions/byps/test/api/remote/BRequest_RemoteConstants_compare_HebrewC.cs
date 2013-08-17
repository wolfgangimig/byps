//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteConstants_compare_HebrewC : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 431648293; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteConstants __byps__remoteT = (RemoteConstants)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_19());				
				__byps__remoteT.async_Compare_HebrewC(_ALEPH, _BETH, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal com.wilutions.byps.test.api.cons.HebrewZ _ALEPH;

		internal com.wilutions.byps.test.api.cons.HebrewZ _BETH;

		#endregion
		
		
		public static readonly long serialVersionUID = 1570751625L;		
	} // end class
}  // end namespace
