using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BApiDescriptor_BUtilityRequests { 
	
		/**
		 * API serialisation version: 0.0.0.1
		 */
		public const long VERSION = 1L;
		
		public readonly static BApiDescriptor instance = new BApiDescriptor(
			"BUtilityRequests",
			"byps.ureq",
			VERSION,
			false) // uniqueObjects
			.addRegistry(new BRegistry_BUtilityRequests());
		
		
	}
}
