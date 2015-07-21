//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.comp
{
	
	public sealed class BRequest_IncompatibleChangeIF_changedClass : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 88979576; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				IncompatibleChangeIF __byps__remoteT = (IncompatibleChangeIF)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());				
				__byps__remoteT.ChangedClass(paramValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal IncompatibleChangeInfo paramValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1831430414L;		
	} // end class
}  // end namespace
