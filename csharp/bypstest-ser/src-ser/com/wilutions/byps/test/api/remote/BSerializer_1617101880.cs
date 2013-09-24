//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setLong1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1617101880 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1617101880();
		
		public BSerializer_1617101880()
			: base(1617101880) {}
		
		public BSerializer_1617101880(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setLong1 obj = (BRequest_RemoteSetTypes_setLong1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._long1, false, com.wilutions.byps.test.api.BSerializer_1457164460.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setLong1 obj = (BRequest_RemoteSetTypes_setLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setLong1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._long1 = (ISet<long>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
