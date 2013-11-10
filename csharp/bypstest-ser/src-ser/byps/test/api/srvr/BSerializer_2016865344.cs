//
// Serializer for byps.test.api.srvr.BRequest_ClientIF_putStreams
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_2016865344 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2016865344();
		
		public BSerializer_2016865344()
			: base(2016865344) {}
		
		public BSerializer_2016865344(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ClientIF_putStreams obj = (BRequest_ClientIF_putStreams)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bbuf.putInt(obj.ctrlValue);
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.strmValue, false, byps.test.api.BSerializer_1218831438.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ClientIF_putStreams obj = (BRequest_ClientIF_putStreams)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_putStreams()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.ctrlValue = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:445
			obj.strmValue = (IList<System.IO.Stream>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
