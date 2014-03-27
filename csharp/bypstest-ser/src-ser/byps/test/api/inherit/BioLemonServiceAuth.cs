using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface BioLemonServiceAuth : BRemote, 
		BioFruitServiceAuth, 
		LemonServiceAuth {
	
		int UseParing();
		void UseParing(BAsyncResult<int> asyncResult) ;
		Task<int> UseParingAsync();
		
		
	}
}  // end namespace
