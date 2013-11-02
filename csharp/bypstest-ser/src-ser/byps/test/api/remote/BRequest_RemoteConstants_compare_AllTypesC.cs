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
			// checkpoint byps.gen.cs.GenApiClass:378
			try {
				RemoteConstants __byps__remoteT = (RemoteConstants)__byps__remote;				
				BAsyncResultSendMethod<bool> __byps__outerResult = new BAsyncResultSendMethod<bool>(__byps__asyncResult, new byps.test.api.BResult_1());				
				__byps__remoteT.Compare_AllTypesC(_bool1s, _bool2s, _char1s, _stringNull, _char2s, _short1s, _int1s, _long1s, _float1s, _double1s, _string1s, _ALL, _arrInt, _arrInt4, _arrStrings, _arrStrings4, _arrAll, BAsyncResultHelper.ToDelegate(__byps__outerResult));
			} catch (Exception e) {
				__byps__asyncResult.setAsyncResult(false, e);
				throw e;
			}
		}		
		
		#endregion
		
		#region Fields
		
		internal bool _bool1s;

		internal bool _bool2s;

		internal char _char1s;

		internal String _stringNull;

		internal char _char2s;

		internal short _short1s;

		internal int _int1s;

		internal long _long1s;

		internal float _float1s;

		internal double _double1s;

		internal String _string1s;

		internal byps.test.api.cons.AllTypesZ _ALL;

		internal int[] _arrInt;

		internal int[,,,] _arrInt4;

		internal String[] _arrStrings;

		internal String[,,,] _arrStrings4;

		internal byps.test.api.cons.AllTypesZ[,] _arrAll;

		#endregion
		
		
		public static readonly long serialVersionUID = 1609344203L;		
	} // end class
}  // end namespace
