//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemotePrimitiveTypes_getStringsWithSpecialChars : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 456456; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:429
			try {
				RemotePrimitiveTypes __byps__remoteT = (RemotePrimitiveTypes)__byps__remote;				
				BAsyncResultSendMethod<IList<String>> __byps__outerResult = new BAsyncResultSendMethod<IList<String>>(__byps__asyncResult, new byps.test.api.BResult_2123584667());				
				__byps__remoteT.GetStringsWithSpecialChars(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 361187255L;		
	} // end class
}  // end namespace
