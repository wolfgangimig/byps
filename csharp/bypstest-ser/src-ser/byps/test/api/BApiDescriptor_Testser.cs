using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BApiDescriptor_Testser { 
	
		/**
		 * API serialisation version: 0.0.0.793
		 */
		public const long VERSION = 793L;
		
		public readonly static BApiDescriptor instance = new BApiDescriptor(
			"Testser",
			"byps.test.api",
			VERSION,
			false) // uniqueObjects
			.addRegistry(new BRegistry_Testser());
		
		
	}
}
