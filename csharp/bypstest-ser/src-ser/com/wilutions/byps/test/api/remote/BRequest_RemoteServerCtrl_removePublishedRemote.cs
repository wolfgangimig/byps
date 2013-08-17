//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteServerCtrl_removePublishedRemote : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 1124545992; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteServerCtrl __byps__remoteT = (RemoteServerCtrl)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_19());				
				__byps__remoteT.async_RemovePublishedRemote(_name, __byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal String _name;

		#endregion
		
		
		public static readonly long serialVersionUID = 1302703010L;		
	} // end class
}  // end namespace
