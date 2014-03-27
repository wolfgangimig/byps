//
// Serializer for byps.test.api.srvr.BRequest_ServerIF_putStreamsOnClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_1934886286 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1934886286();
		
		public BSerializer_1934886286()
			: base(1934886286) {}
		
		public BSerializer_1934886286(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ServerIF_putStreamsOnClient obj = (BRequest_ServerIF_putStreamsOnClient)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.streamsValue, false, byps.test.api.BSerializer_1218831438.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_putStreamsOnClient obj = (BRequest_ServerIF_putStreamsOnClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_putStreamsOnClient()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.streamsValue = (IList<System.IO.Stream>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
