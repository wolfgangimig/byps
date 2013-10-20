using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteConstants : BStub, RemoteConstants, BSerializable {	
		
		public readonly static long serialVersionUID = 431648293L;
		
		public BStub_RemoteConstants(BTransport transport)
			: base(transport) {}			
		
		public void Compare_HebrewC(com.wilutions.byps.test.api.cons.HebrewZ ALEPH, com.wilutions.byps.test.api.cons.HebrewZ BETH) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			Compare_HebrewC(ALEPH, BETH, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void Compare_HebrewC(com.wilutions.byps.test.api.cons.HebrewZ ALEPH, com.wilutions.byps.test.api.cons.HebrewZ BETH, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteConstants_compare_HebrewC req = new BRequest_RemoteConstants_compare_HebrewC();			
			req._ALEPH = ALEPH;
			req._BETH = BETH;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task Compare_HebrewCAsync(com.wilutions.byps.test.api.cons.HebrewZ ALEPH, com.wilutions.byps.test.api.cons.HebrewZ BETH){
			BRequest_RemoteConstants_compare_HebrewC req = new BRequest_RemoteConstants_compare_HebrewC();			
			req._ALEPH = ALEPH;
			req._BETH = BETH;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public bool Compare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, com.wilutions.byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, com.wilutions.byps.test.api.cons.AllTypesZ[,] arrAll) {
			BSyncResult<bool> asyncResult = new BSyncResult<bool>();			
			Compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, BAsyncResultHelper.ToDelegate<bool>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void Compare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, com.wilutions.byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, com.wilutions.byps.test.api.cons.AllTypesZ[,] arrAll, BAsyncResult<bool> asyncResult) {
			BRequest_RemoteConstants_compare_AllTypesC req = new BRequest_RemoteConstants_compare_AllTypesC();			
			req._bool1s = bool1s;
			req._bool2s = bool2s;
			req._char1s = char1s;
			req._stringNull = stringNull;
			req._char2s = char2s;
			req._short1s = short1s;
			req._int1s = int1s;
			req._long1s = long1s;
			req._float1s = float1s;
			req._double1s = double1s;
			req._string1s = string1s;
			req._ALL = ALL;
			req._arrInt = arrInt;
			req._arrInt4 = arrInt4;
			req._arrStrings = arrStrings;
			req._arrStrings4 = arrStrings4;
			req._arrAll = arrAll;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<bool> Compare_AllTypesCAsync(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, com.wilutions.byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, com.wilutions.byps.test.api.cons.AllTypesZ[,] arrAll){
			BRequest_RemoteConstants_compare_AllTypesC req = new BRequest_RemoteConstants_compare_AllTypesC();			
			req._bool1s = bool1s;
			req._bool2s = bool2s;
			req._char1s = char1s;
			req._stringNull = stringNull;
			req._char2s = char2s;
			req._short1s = short1s;
			req._int1s = int1s;
			req._long1s = long1s;
			req._float1s = float1s;
			req._double1s = double1s;
			req._string1s = string1s;
			req._ALL = ALL;
			req._arrInt = arrInt;
			req._arrInt4 = arrInt4;
			req._arrStrings = arrStrings;
			req._arrStrings4 = arrStrings4;
			req._arrAll = arrAll;
			Task<bool> task = Task<bool>.Factory.FromAsync(transport.BeginSend<bool>, transport.EndSend<bool>, req, null);
			return await task;
		}
		
		
	}
}
