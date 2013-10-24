//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteInlineInstance_getActor : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 567395951; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:372
			try {
				RemoteInlineInstance __byps__remoteT = (RemoteInlineInstance)__byps__remote;				
				BAsyncResultSendMethod<byps.test.api.inl.Actor> __byps__outerResult = new BAsyncResultSendMethod<byps.test.api.inl.Actor>(__byps__asyncResult, new byps.test.api.BResult_171948703());				
				__byps__remoteT.GetActor(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 600892860L;		
	} // end class
}  // end namespace
