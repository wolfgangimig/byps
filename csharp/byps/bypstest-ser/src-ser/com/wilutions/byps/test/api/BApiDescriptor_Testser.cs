using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BApiDescriptor_Testser { 
	
		public readonly static int VERSION = 791;
		
		public readonly static BApiDescriptor instance = new BApiDescriptor(
			"Testser",
			"com.wilutions.byps.test.api",
			VERSION,
			false) // uniqueObjects
			.addRegistry(new BRegistry_Testser());
		
		
	}
}
