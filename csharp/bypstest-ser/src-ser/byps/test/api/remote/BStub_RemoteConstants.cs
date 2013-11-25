using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteConstants : BStub, RemoteConstants, BSerializable {	
		
		public readonly static long serialVersionUID = 429088323L;
		
		public BStub_RemoteConstants(BTransport transport)
			: base(transport) {}			
		
		public virtual void Compare_HebrewC(byps.test.api.cons.HebrewZ ALEPH, byps.test.api.cons.HebrewZ BETH) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			Compare_HebrewC(ALEPH, BETH, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void Compare_HebrewC(byps.test.api.cons.HebrewZ ALEPH, byps.test.api.cons.HebrewZ BETH, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteConstants_compare_HebrewC req = new BRequest_RemoteConstants_compare_HebrewC();			
			req.ALEPHValue = ALEPH;
			req.BETHValue = BETH;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task Compare_HebrewCAsync(byps.test.api.cons.HebrewZ ALEPH, byps.test.api.cons.HebrewZ BETH){
			BRequest_RemoteConstants_compare_HebrewC req = new BRequest_RemoteConstants_compare_HebrewC();			
			req.ALEPHValue = ALEPH;
			req.BETHValue = BETH;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual bool Compare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, byps.test.api.cons.AllTypesZ[,] arrAll) {
			BSyncResult<bool> asyncResult = new BSyncResult<bool>();			
			Compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, BAsyncResultHelper.ToDelegate<bool>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void Compare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, byps.test.api.cons.AllTypesZ[,] arrAll, BAsyncResult<bool> asyncResult) {
			BRequest_RemoteConstants_compare_AllTypesC req = new BRequest_RemoteConstants_compare_AllTypesC();			
			req.bool1sValue = bool1s;
			req.bool2sValue = bool2s;
			req.char1sValue = char1s;
			req.stringNullValue = stringNull;
			req.char2sValue = char2s;
			req.short1sValue = short1s;
			req.int1sValue = int1s;
			req.long1sValue = long1s;
			req.float1sValue = float1s;
			req.double1sValue = double1s;
			req.string1sValue = string1s;
			req.ALLValue = ALL;
			req.arrIntValue = arrInt;
			req.arrInt4Value = arrInt4;
			req.arrStringsValue = arrStrings;
			req.arrStrings4Value = arrStrings4;
			req.arrAllValue = arrAll;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<bool> Compare_AllTypesCAsync(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, byps.test.api.cons.AllTypesZ[,] arrAll){
			BRequest_RemoteConstants_compare_AllTypesC req = new BRequest_RemoteConstants_compare_AllTypesC();			
			req.bool1sValue = bool1s;
			req.bool2sValue = bool2s;
			req.char1sValue = char1s;
			req.stringNullValue = stringNull;
			req.char2sValue = char2s;
			req.short1sValue = short1s;
			req.int1sValue = int1s;
			req.long1sValue = long1s;
			req.float1sValue = float1s;
			req.double1sValue = double1s;
			req.string1sValue = string1s;
			req.ALLValue = ALL;
			req.arrIntValue = arrInt;
			req.arrInt4Value = arrInt4;
			req.arrStringsValue = arrStrings;
			req.arrStrings4Value = arrStrings4;
			req.arrAllValue = arrAll;
			Task<bool> task = Task<bool>.Factory.FromAsync(transport.BeginSend<bool>, transport.EndSend<bool>, req, null);
			return await task;
		}
		
		
	}
}
