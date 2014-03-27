//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public sealed class BRequest_RemoteConstants_compare_AllTypesC : BMethodRequest, BSerializable
	{
	
		#region Execute
		
		public override int getRemoteId() { return 2045242510; }
		
		public override void execute(BRemote __byps__remote, BAsyncResultIF<Object> __byps__asyncResult) {
			// checkpoint byps.gen.cs.GenApiClass:406
			try {
				RemoteConstants __byps__remoteT = (RemoteConstants)__byps__remote;				
				BAsyncResultSendMethod<bool> __byps__outerResult = new BAsyncResultSendMethod<bool>(__byps__asyncResult, new byps.test.api.BResult_1());				
				__byps__remoteT.Compare_AllTypesC(bool1sValue, bool2sValue, char1sValue, stringNullValue, char2sValue, short1sValue, int1sValue, long1sValue, float1sValue, double1sValue, string1sValue, ALLValue, arrIntValue, arrInt4Value, arrStringsValue, arrStrings4Value, arrAllValue, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(false, e);
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal bool bool1sValue;

		internal bool bool2sValue;

		internal char char1sValue;

		internal String stringNullValue;

		internal char char2sValue;

		internal short short1sValue;

		internal int int1sValue;

		internal long long1sValue;

		internal float float1sValue;

		internal double double1sValue;

		internal String string1sValue;

		internal byps.test.api.cons.AllTypesZ ALLValue;

		internal int[] arrIntValue;

		internal int[,,,] arrInt4Value;

		internal String[] arrStringsValue;

		internal String[,,,] arrStrings4Value;

		internal byps.test.api.cons.AllTypesZ[,] arrAllValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1609344203L;		
	} // end class
}  // end namespace
