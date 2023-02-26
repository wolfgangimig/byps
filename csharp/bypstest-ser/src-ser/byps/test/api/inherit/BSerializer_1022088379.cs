//
// Serializer for byps.test.api.inherit.BRequest_LemonService_pick
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_1022088379 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1022088379();
		
		public BSerializer_1022088379()
			: base(1022088379) {}
		
		public BSerializer_1022088379(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_LemonService_pick obj = (BRequest_LemonService_pick)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putString(obj.fromTreeValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.sessValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_LemonService_pick obj = (BRequest_LemonService_pick)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_LemonService_pick()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.fromTreeValue = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.sessValue = (byps.test.api.auth.SessionInfo)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
