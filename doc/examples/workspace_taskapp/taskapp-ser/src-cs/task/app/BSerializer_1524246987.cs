//
// Serializer for task.app.BRequest_TaskService_logout
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BSerializer_1524246987 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1524246987();
		
		public BSerializer_1524246987()
			: base(1524246987) {}
		
		public BSerializer_1524246987(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_TaskService_logout obj = (BRequest_TaskService_logout)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.tokenValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_TaskService_logout obj = (BRequest_TaskService_logout)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_TaskService_logout()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.tokenValue = (task.app.Token)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
