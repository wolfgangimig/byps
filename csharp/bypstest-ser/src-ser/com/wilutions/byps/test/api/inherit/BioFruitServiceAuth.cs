using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface BioFruitServiceAuth : BRemote, 
		FruitServiceAuth {
	
		bool Certify(String param);
		void Certify(String param, BAsyncResult<bool> asyncResult) ;
		Task<bool> CertifyAsync(String param);
		
		
	}
}  // end namespace
