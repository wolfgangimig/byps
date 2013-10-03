using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:81
	public interface BioLemonServiceAuth : BRemote, 
		BioFruitServiceAuth, 
		LemonServiceAuth {
	
		int UseParing();
		void UseParingAsync(BAsyncResult<int> asyncResult) ;
		IAsyncResult BeginUseParing(AsyncCallback callback, object state);
		int EndUseParing(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
