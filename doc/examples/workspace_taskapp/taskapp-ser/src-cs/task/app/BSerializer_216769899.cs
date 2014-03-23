//
// Serializer for task.app.BStub_TaskService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BSerializer_216769899 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_216769899();
		
		public BSerializer_216769899()
			: base(216769899) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_TaskService(transport);
		}
		
	}
} // namespace
