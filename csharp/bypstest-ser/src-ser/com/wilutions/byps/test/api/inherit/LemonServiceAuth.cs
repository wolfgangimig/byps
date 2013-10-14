using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:81
	public interface LemonServiceAuth : BRemote, 
		FruitServiceAuth {
	
		String Pick(String fromTree);
		void PickAsync(String fromTree, BAsyncResult<String> asyncResult) ;
		IAsyncResult BeginPick(String fromTree, AsyncCallback callback, object state);
		String EndPick(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
