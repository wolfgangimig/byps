using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface LemonService : BRemote, 
		FruitService {
	
		String Pick(com.wilutions.byps.test.api.auth.SessionInfo sess, String fromTree);
		void Pick(com.wilutions.byps.test.api.auth.SessionInfo sess, String fromTree, BAsyncResult<String> asyncResult) ;
		Task<String> PickAsync(com.wilutions.byps.test.api.auth.SessionInfo sess, String fromTree);
		
		
	}
}  // end namespace
