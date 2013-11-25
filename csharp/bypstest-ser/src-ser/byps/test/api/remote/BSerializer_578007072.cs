//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_parseDate
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_578007072 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_578007072();
		
		public BSerializer_578007072()
			: base(578007072) {}
		
		public BSerializer_578007072(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_parseDate obj = (BRequest_RemotePrimitiveTypes_parseDate)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putDate(obj.dateValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_parseDate obj = (BRequest_RemotePrimitiveTypes_parseDate)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_parseDate()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.dateValue = bbuf.getDate();
			
			return obj;
		}
		
	}
} // namespace
