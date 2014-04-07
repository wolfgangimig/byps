//
// Serializer for task.app.BRequest_TaskService_getTasks
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BSerializer_280075325 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_280075325();
		
		public BSerializer_280075325()
			: base(280075325) {}
		
		public BSerializer_280075325(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_TaskService_getTasks obj = (BRequest_TaskService_getTasks)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_TaskService_getTasks()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
