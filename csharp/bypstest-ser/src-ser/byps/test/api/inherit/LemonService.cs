using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface LemonService : BRemote, 
		FruitService {
	
		String Pick(byps.test.api.auth.SessionInfo sess, String fromTree);
		void Pick(byps.test.api.auth.SessionInfo sess, String fromTree, BAsyncResult<String> asyncResult) ;
		Task<String> PickAsync(byps.test.api.auth.SessionInfo sess, String fromTree);
		
		
	}
}  // end namespace
