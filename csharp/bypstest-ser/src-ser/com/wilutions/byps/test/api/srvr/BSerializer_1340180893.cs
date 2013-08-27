//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_callClientParallel
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_1340180893 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1340180893();
		
		public BSerializer_1340180893()
			: base(1340180893) {}
		
		public BSerializer_1340180893(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: v */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ServerIF_callClientParallel obj = (BRequest_ServerIF_callClientParallel)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._v);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_callClientParallel obj = (BRequest_ServerIF_callClientParallel)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_callClientParallel()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
