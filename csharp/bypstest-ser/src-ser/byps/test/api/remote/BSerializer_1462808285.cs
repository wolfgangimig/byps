//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setByte1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1462808285 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1462808285();
		
		public BSerializer_1462808285()
			: base(1462808285) {}
		
		public BSerializer_1462808285(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setByte1 obj = (BRequest_RemoteSetTypes_setByte1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.byte1Value, false, byps.test.api.BSerializer_31512998.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setByte1 obj = (BRequest_RemoteSetTypes_setByte1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setByte1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.byte1Value = (HashSet<byte>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
