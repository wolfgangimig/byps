using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:81
	public interface FruitService : BRemote, 
		PlantService {
	
		String Squeeze();
		void SqueezeAsync(BAsyncResult<String> asyncResult) ;
		IAsyncResult BeginSqueeze(AsyncCallback callback, object state);
		String EndSqueeze(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
