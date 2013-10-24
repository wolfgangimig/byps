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
			// checkpoint byps.gen.cs.GenApiClass:372
			try {
				RemotePrimitiveTypes __byps__remoteT = (RemotePrimitiveTypes)__byps__remote;				
				BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());				
				__byps__remoteT.SendAllTypes(_b, _c, _s, _i, _l, _f, _d, _str, _pt, _o, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal bool _b;

		internal char _c;

		internal short _s;

		internal int _i;

		internal long _l;

		internal float _f;

		internal double _d;

		internal String _str;

		internal byps.test.api.prim.PrimitiveTypes _pt;

		internal Object _o;

		#endregion
		
		
		public static readonly long serialVersionUID = 677876863L;		
	} // end class
}  // end namespace
