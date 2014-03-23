//
// Serializer for task.app.BResult_323961470
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BSerializer_771996649 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_771996649();
		
		public BSerializer_771996649()
			: base(771996649) {}
		
		public BSerializer_771996649(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_323961470 obj = (BResult_323961470)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_323961470 obj = (BResult_323961470)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_323961470()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (task.app.Token)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
