//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.comp
{
	
	public sealed class BRequest_IncompatibleChangeIF_changedParameterType : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 88979576; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				IncompatibleChangeIF __byps__remoteT = (IncompatibleChangeIF)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());				
				__byps__remoteT.ChangedParameterType(intParamChangedToStringValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int intParamChangedToStringValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 214991897L;		
	} // end class
}  // end namespace
