//
// Serializer for byps.test.api.srvr.BRequest_ServerIF_getClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_190669475 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_190669475();
		
		public BSerializer_190669475()
			: base(190669475) {}
		
		public BSerializer_190669475(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ServerIF_getClient obj = (BRequest_ServerIF_getClient)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.idValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_getClient obj = (BRequest_ServerIF_getClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_getClient()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.idValue = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
