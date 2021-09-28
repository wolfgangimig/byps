//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteListTypes_getChar1 : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1233438138; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:419
			try {
				RemoteListTypes __byps__remoteT = (RemoteListTypes)__byps__remote;				
				BAsyncResultSendMethod<IList<char>> __byps__outerResult = new BAsyncResultSendMethod<IList<char>>(__byps__asyncResult, new byps.test.api.BResult_1661807911());				
				__byps__remoteT.GetChar1(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 608885621L;		
	} // end class
}  // end namespace
