﻿using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface BioLemonService : BRemote, 
		BioFruitService, 
		LemonService {
	
		int UseParing();
		void UseParing(BAsyncResult<int> asyncResult) ;
		Task<int> UseParingAsync();
		
		
	}
}  // end namespace
