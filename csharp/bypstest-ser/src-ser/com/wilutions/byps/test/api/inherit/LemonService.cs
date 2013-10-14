using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:81
	public interface LemonService : BRemote, 
		FruitService {
	
		String Pick(com.wilutions.byps.test.api.auth.SessionInfo sess, String fromTree);
		void PickAsync(com.wilutions.byps.test.api.auth.SessionInfo sess, String fromTree, BAsyncResult<String> asyncResult) ;
		IAsyncResult BeginPick(com.wilutions.byps.test.api.auth.SessionInfo sess, String fromTree, AsyncCallback callback, object state);
		String EndPick(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
