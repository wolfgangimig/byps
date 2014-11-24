using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BApiDescriptor_UtilityRequests { 
	
		/**
		 * API serialisation version: 0.0.0.1
		 */
		public const long VERSION = 1L;
		
		public readonly static BApiDescriptor instance = new BApiDescriptor(
			"UtilityRequests",
			"byps.ureq",
			VERSION,
			false) // uniqueObjects
			.addRegistry(new BRegistry_UtilityRequests());
		
		
	}
}
