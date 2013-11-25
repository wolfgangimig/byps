//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteServerCtrl_getPublishedRemote : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 2037577312; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				RemoteServerCtrl __byps__remoteT = (RemoteServerCtrl)__byps__remote;				
				BAsyncResultSendMethod<BRemote> __byps__outerResult = new BAsyncResultSendMethod<BRemote>(__byps__asyncResult, new byps.test.api.BResult_16());				
				__byps__remoteT.GetPublishedRemote(nameValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal String nameValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 648762723L;		
	} // end class
}  // end namespace
