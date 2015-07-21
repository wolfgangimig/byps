//
// Serializer for byps.test.api.comp.BRequest_IncompatibleChangeIF_changedClass
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.comp
{
	
	public class BSerializer_1831430414 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1831430414();
		
		public BSerializer_1831430414()
			: base(1831430414) {}
		
		public BSerializer_1831430414(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_IncompatibleChangeIF_changedClass obj = (BRequest_IncompatibleChangeIF_changedClass)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.paramValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_IncompatibleChangeIF_changedClass obj = (BRequest_IncompatibleChangeIF_changedClass)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_IncompatibleChangeIF_changedClass()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.paramValue = (byps.test.api.comp.IncompatibleChangeInfo)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
