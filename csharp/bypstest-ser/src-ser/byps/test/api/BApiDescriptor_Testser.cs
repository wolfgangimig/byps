using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BApiDescriptor_Testser { 
	
		/**
		 * API serialisation version: 0.0.0.791
		 */
		public readonly static long VERSION = 791L;
		
		public readonly static BApiDescriptor instance = new BApiDescriptor(
			"Testser",
			"byps.test.api",
			VERSION,
			false) // uniqueObjects
			.addRegistry(new BRegistry_Testser());
		
		
	}
}
