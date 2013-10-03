using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:81
	public interface BioFruitServiceAuth : BRemote, 
		FruitServiceAuth {
	
		bool Certify(String param);
		void CertifyAsync(String param, BAsyncResult<bool> asyncResult) ;
		IAsyncResult BeginCertify(String param, AsyncCallback callback, object state);
		bool EndCertify(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
