//
// Serializer for task.app.BRequest_TaskService_login
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BSerializer_366472542 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_366472542();
		
		public BSerializer_366472542()
			: base(366472542) {}
		
		public BSerializer_366472542(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_TaskService_login obj = (BRequest_TaskService_login)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.nameValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.pwdValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_TaskService_login obj = (BRequest_TaskService_login)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_TaskService_login()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.nameValue = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.pwdValue = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
