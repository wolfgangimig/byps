using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface BioLemonServiceAuth : BRemote, 
		BioFruitServiceAuth, 
		LemonServiceAuth {
	
		int UseParing();
		void UseParing(BAsyncResult<int> asyncResult) ;
		Task<int> UseParingAsync();
		
		
	}
}  // end namespace
