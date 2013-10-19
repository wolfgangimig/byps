//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public sealed class BRequest_RemotePrimitiveTypes_getByte : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1341983932; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint com.wilutions.byps.gen.cs.GenApiClass:372
			try {
				RemotePrimitiveTypes __byps__remoteT = (RemotePrimitiveTypes)__byps__remote;				
				BAsyncResultSendMethod<byte> __byps__outerResult = new BAsyncResultSendMethod<byte>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_2());				
				__byps__remoteT.GetByte(BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(((byte)0), e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		#endregion
		
		
		public static readonly long serialVersionUID = 2091006964L;		
	} // end class
}  // end namespace
