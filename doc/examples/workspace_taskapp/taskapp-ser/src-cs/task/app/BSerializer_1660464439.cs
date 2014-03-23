//
// Serializer for task.app.TaskInfo
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BSerializer_1660464439 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1660464439();
		
		public BSerializer_1660464439()
			: base(1660464439) {}
		
		public BSerializer_1660464439(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			TaskInfo obj = (TaskInfo)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putDate(obj.DueDate);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.Id);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.Todo);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.UserName);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			TaskInfo obj = (TaskInfo)(obj1 != null ? obj1 : bin.onObjectCreated(new TaskInfo()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.DueDate = bbuf.getDate();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Id = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Todo = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.UserName = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
