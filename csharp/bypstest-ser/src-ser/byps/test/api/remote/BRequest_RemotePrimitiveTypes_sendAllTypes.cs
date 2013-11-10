//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemotePrimitiveTypes_sendAllTypes : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 1178916877; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:380
			try {
				RemotePrimitiveTypes __byps__remoteT = (RemotePrimitiveTypes)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());				
				__byps__remoteT.SendAllTypes(bValue, cValue, sValue, iValue, lValue, fValue, dValue, strValue, ptValue, oValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal bool bValue;

		internal char cValue;

		internal short sValue;

		internal int iValue;

		internal long lValue;

		internal float fValue;

		internal double dValue;

		internal String strValue;

		internal byps.test.api.prim.PrimitiveTypes ptValue;

		internal Object oValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 677876863L;		
	} // end class
}  // end namespace
