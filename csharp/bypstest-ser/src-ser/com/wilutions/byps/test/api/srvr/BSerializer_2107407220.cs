//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_2107407220 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2107407220();
		
		public BSerializer_2107407220()
			: base(2107407220) {}
		
		public BSerializer_2107407220(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ServerIF_getClient obj = (BRequest_ServerIF_getClient)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._id);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_getClient obj = (BRequest_ServerIF_getClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_getClient()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._id = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
