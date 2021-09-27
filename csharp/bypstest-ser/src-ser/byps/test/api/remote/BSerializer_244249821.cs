//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_setLong
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_244249821 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_244249821();
		
		public BSerializer_244249821()
			: base(244249821) {}
		
		public BSerializer_244249821(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_setLong obj = (BRequest_RemotePrimitiveTypes_setLong)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putLong(obj.vValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_setLong obj = (BRequest_RemotePrimitiveTypes_setLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setLong()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.vValue = bbuf.getLong();
			
			return obj;
		}
		
	}
} // namespace
