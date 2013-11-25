//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setByte2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1462808284 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1462808284();
		
		public BSerializer_1462808284()
			: base(1462808284) {}
		
		public BSerializer_1462808284(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setByte2 obj = (BRequest_RemoteSetTypes_setByte2)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.byte2Value, false, byps.test.api.BSerializer_2052431866.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setByte2 obj = (BRequest_RemoteSetTypes_setByte2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setByte2()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.byte2Value = (ISet<byte[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
