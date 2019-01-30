//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemotePrimitiveTypes_makeDate : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 456456; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				RemotePrimitiveTypes __byps__remoteT = (RemotePrimitiveTypes)__byps__remote;				
				BAsyncResultSendMethod<DateTime> __byps__outerResult = new BAsyncResultSendMethod<DateTime>(__byps__asyncResult, new byps.test.api.BResult_17());				
				__byps__remoteT.MakeDate(yearValue, monthValue, dayValue, hourValue, minuteValue, secondValue, millisecondValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(null, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal int yearValue;

		internal int monthValue;

		internal int dayValue;

		internal int hourValue;

		internal int minuteValue;

		internal int secondValue;

		internal int millisecondValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1918934973L;		
	} // end class
}  // end namespace
