using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface LemonServiceAuth : BRemote, 
		FruitServiceAuth {
	
		String Pick(String fromTree);
		void Pick(String fromTree, BAsyncResult<String> asyncResult) ;
		Task<String> PickAsync(String fromTree);
		
		
	}
}  // end namespace
