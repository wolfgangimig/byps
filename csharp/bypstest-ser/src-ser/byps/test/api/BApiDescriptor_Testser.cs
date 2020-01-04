using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BApiDescriptor_Testser { 
	
		/**
		 * API serialisation version: 794.0.0.0
		 */
		public const long VERSION = 79400000000000000L;
		
		public readonly static BApiDescriptor instance = new BApiDescriptor(
			"Testser",
			"byps.test.api",
			VERSION,
			false) // uniqueObjects
			.addRegistry(new BRegistry_Testser());
		
		
	}
}
