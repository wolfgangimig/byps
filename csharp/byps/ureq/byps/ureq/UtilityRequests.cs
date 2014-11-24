using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface UtilityRequests : BRemote {
	
		void CancelMessage(long messageId);
		void CancelMessage(long messageId, BAsyncResult<Object> asyncResult) ;
		
		
	}
}  // end namespace
