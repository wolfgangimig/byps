//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_putStreamsOnClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_1367013829 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1367013829();
		
		public BSerializer_1367013829()
			: base(1367013829) {}
		
		public BSerializer_1367013829(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: streams */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_ServerIF_putStreamsOnClient obj = (BRequest_ServerIF_putStreamsOnClient)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._streams, false, com.wilutions.byps.test.api.BSerializer_1218831438.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_putStreamsOnClient obj = (BRequest_ServerIF_putStreamsOnClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_putStreamsOnClient()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._streams = (IList<System.IO.Stream>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
