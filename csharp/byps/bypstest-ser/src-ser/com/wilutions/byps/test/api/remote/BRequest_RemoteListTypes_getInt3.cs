//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteListTypes_getInt3 : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public int getRemoteId() { return 380156079; }
		
		public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteListTypes __byps__remoteT = (RemoteListTypes)__byps__remote;				
				BAsyncResultSendMethod<IList<IList<int>>> __byps__outerResult = new BAsyncResultSendMethod<IList<IList<int>>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1746702954());				
				__byps__remoteT.async_GetInt3(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 874047763L;		
	} // end class
}  // end namespace
