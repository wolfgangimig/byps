using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface BioFruitService : BRemote, 
		FruitService {
	
		bool Certify(String param);
		void Certify(String param, BAsyncResult<bool> asyncResult) ;
		Task<bool> CertifyAsync(String param);
		
		
	}
}  // end namespace
