//
// Serializer for byps.test.api.srvr.BRequest_ServerIF_setPartner
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_1332497686 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1332497686();
		
		public BSerializer_1332497686()
			: base(1332497686) {}
		
		public BSerializer_1332497686(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ServerIF_setPartner obj = (BRequest_ServerIF_setPartner)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.clientValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_setPartner obj = (BRequest_ServerIF_setPartner)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_setPartner()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.clientValue = (byps.test.api.srvr.ClientIF)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
