//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setBoolean1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_2091396559 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2091396559();
		
		public BSerializer_2091396559()
			: base(2091396559) {}
		
		public BSerializer_2091396559(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setBoolean1 obj = (BRequest_RemoteSetTypes_setBoolean1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.boolean1Value, false, byps.test.api.BSerializer_1365696060.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setBoolean1 obj = (BRequest_RemoteSetTypes_setBoolean1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setBoolean1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.boolean1Value = (ISet<bool>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
