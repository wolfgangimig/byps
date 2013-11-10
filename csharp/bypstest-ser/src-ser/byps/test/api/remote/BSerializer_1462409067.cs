//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setChar1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1462409067 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1462409067();
		
		public BSerializer_1462409067()
			: base(1462409067) {}
		
		public BSerializer_1462409067(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setChar1 obj = (BRequest_RemoteSetTypes_setChar1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.char1Value, false, byps.test.api.BSerializer_936607009.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setChar1 obj = (BRequest_RemoteSetTypes_setChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setChar1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.char1Value = (HashSet<char>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
