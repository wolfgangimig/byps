//
// Serializer for task.app.BResult_1182472339
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BSerializer_2101800006 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2101800006();
		
		public BSerializer_2101800006()
			: base(2101800006) {}
		
		public BSerializer_2101800006(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1182472339 obj = (BResult_1182472339)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, task.app.BSerializer_1182472339.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1182472339 obj = (BResult_1182472339)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1182472339()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (IList<task.app.TaskInfo>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
