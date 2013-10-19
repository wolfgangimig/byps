using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface PlantService : BRemote {
	
		String Grow();
		void Grow(BAsyncResult<String> asyncResult) ;
		Task<String> GrowAsync();
		
		
	}
}  // end namespace
