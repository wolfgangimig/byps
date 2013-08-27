//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ClientIF_putStreams
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_242798857 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_242798857();
		
		public BSerializer_242798857()
			: base(242798857) {}
		
		public BSerializer_242798857(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: strm */ + 4			
			       /* pos=4: ctrl */ + 4			
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ClientIF_putStreams obj = (BRequest_ClientIF_putStreams)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._ctrl);
			bout.writeObj(obj._strm, false, com.wilutions.byps.test.api.BSerializer_1218831438.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ClientIF_putStreams obj = (BRequest_ClientIF_putStreams)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_putStreams()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._ctrl = bbuf.getInt();
			obj._strm = (IList<System.IO.Stream>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
