using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	/// <summary>
	/// Interface functions to verify constant definitions.
	/// </summary>
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteConstants : BRemote {
	
		void Compare_HebrewC(byps.test.api.cons.HebrewZ ALEPH, byps.test.api.cons.HebrewZ BETH);
		void Compare_HebrewC(byps.test.api.cons.HebrewZ ALEPH, byps.test.api.cons.HebrewZ BETH, BAsyncResult<Object> asyncResult) ;
		Task Compare_HebrewCAsync(byps.test.api.cons.HebrewZ ALEPH, byps.test.api.cons.HebrewZ BETH);
		
		bool Compare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, byps.test.api.cons.AllTypesZ[,] arrAll);
		void Compare_AllTypesC(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, byps.test.api.cons.AllTypesZ[,] arrAll, BAsyncResult<bool> asyncResult) ;
		Task<bool> Compare_AllTypesCAsync(bool bool1s, bool bool2s, char char1s, String stringNull, char char2s, short short1s, int int1s, long long1s, float float1s, double double1s, String string1s, byps.test.api.cons.AllTypesZ ALL, int[] arrInt, int[,,,] arrInt4, String[] arrStrings, String[,,,] arrStrings4, byps.test.api.cons.AllTypesZ[,] arrAll);
		
		
	}
}  // end namespace
