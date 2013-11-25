//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_makeDate
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1918934973 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1918934973();
		
		public BSerializer_1918934973()
			: base(1918934973) {}
		
		public BSerializer_1918934973(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_makeDate obj = (BRequest_RemotePrimitiveTypes_makeDate)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.dayValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.hourValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.millisecondValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.minuteValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.monthValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.secondValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.yearValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_makeDate obj = (BRequest_RemotePrimitiveTypes_makeDate)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_makeDate()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.dayValue = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.hourValue = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.millisecondValue = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.minuteValue = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.monthValue = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.secondValue = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.yearValue = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
