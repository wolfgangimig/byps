//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setObj1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_462464544 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_462464544();
		
		public BSerializer_462464544()
			: base(462464544) {}
		
		public BSerializer_462464544(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setObj1 obj = (BRequest_RemoteSetTypes_setObj1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._obj1, false, byps.BSerializer_14.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setObj1 obj = (BRequest_RemoteSetTypes_setObj1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setObj1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._obj1 = (ISet<Object>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
