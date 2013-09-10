using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteConstants.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteConstants : BSkeleton, RemoteConstants {	
		
		public readonly static long serialVersionUID = 431648293L;
		
		public virtual void Compare_HebrewC(com.wilutions.byps.test.api.cons.HebrewZ ALEPH, com.wilutions.byps.test.api.cons.HebrewZ BETH) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_Compare_HebrewC(com.wilutions.byps.test.api.cons.HebrewZ ALEPH, com.wilutions.byps.test.api.cons.HebrewZ BETH, BAsyncResult<Object> asyncResult) {
			try {
				Compare_HebrewC(ALEPH, BETH);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginCompare_HebrewC(com.wilutions.byps.test.api.cons.HebrewZ ALEPH, com.wilutions.byps.test.api.cons.HebrewZ BETH, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndCompare_HebrewC(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual bool Compare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, com.wilutions.byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, com.wilutions.byps.test.api.cons.AllTypesZ[,] arrAll) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_Compare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, com.wilutions.byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, com.wilutions.byps.test.api.cons.AllTypesZ[,] arrAll, BAsyncResult<bool> asyncResult) {
			try {
				bool ret = Compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(false, e);
			}
		}
		public IAsyncResult BeginCompare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, com.wilutions.byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, com.wilutions.byps.test.api.cons.AllTypesZ[,] arrAll, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public bool EndCompare_AllTypesC(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		
	}
}
