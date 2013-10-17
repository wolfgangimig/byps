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
			Compare_HebrewCAsync(ALEPH, BETH, asyncResult);
			asyncResult.GetResult();			
		}
		public void Compare_HebrewCAsync(com.wilutions.byps.test.api.cons.HebrewZ ALEPH, com.wilutions.byps.test.api.cons.HebrewZ BETH, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteConstants_compare_HebrewC req = new BRequest_RemoteConstants_compare_HebrewC();			
			req._ALEPH = ALEPH;
			req._BETH = BETH;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginCompare_HebrewC(com.wilutions.byps.test.api.cons.HebrewZ ALEPH, com.wilutions.byps.test.api.cons.HebrewZ BETH, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			Compare_HebrewCAsync(ALEPH, BETH, _byps_ret);
			return _byps_ret;
		}
		public Object EndCompare_HebrewC(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task Compare_HebrewCTask(com.wilutions.byps.test.api.cons.HebrewZ ALEPH, com.wilutions.byps.test.api.cons.HebrewZ BETH) {
			await Task.Factory.FromAsync(BeginCompare_HebrewC, EndCompare_HebrewC, ALEPH, BETH, null);
		}
		
		public bool Compare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, com.wilutions.byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, com.wilutions.byps.test.api.cons.AllTypesZ[,] arrAll) {
			BSyncResult<bool> asyncResult = new BSyncResult<bool>();			
			Compare_AllTypesCAsync(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, asyncResult);
			return asyncResult.GetResult();			
		}
		public void Compare_AllTypesCAsync(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, com.wilutions.byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, com.wilutions.byps.test.api.cons.AllTypesZ[,] arrAll, BAsyncResult<bool> asyncResult) {
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
			BAsyncResultReceiveMethod<bool> outerResult = new BAsyncResultReceiveMethod<bool>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginCompare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, com.wilutions.byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, com.wilutions.byps.test.api.cons.AllTypesZ[,] arrAll, AsyncCallback callback, object state){
			BAsyncProgModel<bool> _byps_ret = new BAsyncProgModel<bool>(callback, state);
			Compare_AllTypesCAsync(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, _byps_ret);
			return _byps_ret;
		}
		public bool EndCompare_AllTypesC(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<bool>)asyncResult).Result;
		}
		public async Task<bool> Compare_AllTypesCTask(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, com.wilutions.byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, com.wilutions.byps.test.api.cons.AllTypesZ[,] arrAll) {
			return await Task<bool>.Factory.FromAsync(BeginCompare_AllTypesC, EndCompare_AllTypesC, bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, null);
		}
		
		
	}
}
