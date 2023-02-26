//
// Serializer for byps.test.api.srvr.BRequest_ServerIF_registerWithClientMap
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_1533268444 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1533268444();
		
		public BSerializer_1533268444()
			: base(1533268444) {}
		
		public BSerializer_1533268444(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ServerIF_registerWithClientMap obj = (BRequest_ServerIF_registerWithClientMap)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putInt(obj.idValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_registerWithClientMap obj = (BRequest_ServerIF_registerWithClientMap)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_registerWithClientMap()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.idValue = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
