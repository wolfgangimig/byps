//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_registerWithClientMap
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_1921080901 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1921080901();
		
		public BSerializer_1921080901()
			: base(1921080901) {}
		
		public BSerializer_1921080901(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: id */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_ServerIF_registerWithClientMap obj = (BRequest_ServerIF_registerWithClientMap)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._id);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_registerWithClientMap obj = (BRequest_ServerIF_registerWithClientMap)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_registerWithClientMap()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._id = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
