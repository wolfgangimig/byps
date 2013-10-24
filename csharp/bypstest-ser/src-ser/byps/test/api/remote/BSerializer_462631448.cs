//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setInt1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_462631448 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_462631448();
		
		public BSerializer_462631448()
			: base(462631448) {}
		
		public BSerializer_462631448(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setInt1 obj = (BRequest_RemoteSetTypes_setInt1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._int1, false, byps.test.api.BSerializer_1493282670.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setInt1 obj = (BRequest_RemoteSetTypes_setInt1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setInt1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._int1 = (ISet<int>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
