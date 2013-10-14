using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:81
	public interface PlantService : BRemote {
	
		String Grow();
		void GrowAsync(BAsyncResult<String> asyncResult) ;
		IAsyncResult BeginGrow(AsyncCallback callback, object state);
		String EndGrow(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
