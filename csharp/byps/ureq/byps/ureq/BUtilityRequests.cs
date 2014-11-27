using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	/// <summary>
	/// Interface with internally used utility functions.
	/// </summary>
	/// <remarks>
	/// Hint: This API does not support versioning.
	/// </remarks>
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface BUtilityRequests : BRemote {
	
		void CancelMessage(long messageId);
		void CancelMessage(long messageId, BAsyncResult<Object> asyncResult) ;
		
		IDictionary<String,String> TestAdapter(String functionName, IDictionary<String,String> @params);
		void TestAdapter(String functionName, IDictionary<String,String> @params, BAsyncResult<IDictionary<String,String>> asyncResult) ;
		
		IDictionary<String,String> Execute(String functionName, IDictionary<String,String> @params);
		void Execute(String functionName, IDictionary<String,String> @params, BAsyncResult<IDictionary<String,String>> asyncResult) ;
		
		
	}
}  // end namespace
