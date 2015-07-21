//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.comp
{
	
	public sealed class BRequest_IncompatibleChangeIF_changedReturnType : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 88979576; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				IncompatibleChangeIF __byps__remoteT = (IncompatibleChangeIF)__byps__remote;				
				BAsyncResultSendMethod<int> __byps__outerResult = new BAsyncResultSendMethod<int>(__byps__asyncResult, new byps.test.api.BResult_5());				
				__byps__remoteT.ChangedReturnType(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(0, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 262583988L;		
	} // end class
}  // end namespace
