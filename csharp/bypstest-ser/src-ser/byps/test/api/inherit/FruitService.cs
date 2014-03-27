using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface FruitService : BRemote, 
		PlantService {
	
		String Squeeze();
		void Squeeze(BAsyncResult<String> asyncResult) ;
		Task<String> SqueezeAsync();
		
		
	}
}  // end namespace
