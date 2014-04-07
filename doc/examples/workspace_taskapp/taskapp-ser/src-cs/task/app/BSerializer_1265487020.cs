//
// Serializer for task.app.BRequest_TaskService_removeTask
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BSerializer_1265487020 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1265487020();
		
		public BSerializer_1265487020()
			: base(1265487020) {}
		
		public BSerializer_1265487020(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_TaskService_removeTask obj = (BRequest_TaskService_removeTask)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putLong(obj.taskIdValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_TaskService_removeTask obj = (BRequest_TaskService_removeTask)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_TaskService_removeTask()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.taskIdValue = bbuf.getLong();
			
			return obj;
		}
		
	}
} // namespace
