using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	/// <summary>
	/// Interface used to check BExceptionC#PROCESSING.
	/// </summary>
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteProcessingEx : BRemote {
	
		/// <summary>
		/// This function sleeps the given number of seconds and returns true.
		/// </summary>
		bool GetValueAfterProcessingExceptions(int sleepSeconds);
		void GetValueAfterProcessingExceptions(int sleepSeconds, BAsyncResult<bool> asyncResult) ;
		/// <summary>
		/// This function sleeps the given number of seconds and returns true.
		/// </summary>
		Task<bool> GetValueAfterProcessingExceptionsAsync(int sleepSeconds);
		
		
	}
}  // end namespace
