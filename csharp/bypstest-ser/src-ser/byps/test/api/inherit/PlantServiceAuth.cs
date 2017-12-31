using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface PlantServiceAuth : BRemote {
	
		String Grow();
		void Grow(BAsyncResult<String> asyncResult) ;
		Task<String> GrowAsync();
		
		
	}
}  // end namespace
