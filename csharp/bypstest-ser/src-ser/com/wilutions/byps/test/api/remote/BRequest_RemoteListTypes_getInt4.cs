//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemoteListTypes_getInt4 : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 380156079; }
		
		public override void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) {
			try {
				RemoteListTypes __byps__remoteT = (RemoteListTypes)__byps__remote;				
				BAsyncResultSendMethod<IList<IDictionary<int,IList<HashSet<int>>>>> __byps__outerResult = new BAsyncResultSendMethod<IList<IDictionary<int,IList<HashSet<int>>>>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1633500852());				
				__byps__remoteT.async_GetInt4(__byps__outerResult);
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 874047764L;		
	} // end class
}  // end namespace
