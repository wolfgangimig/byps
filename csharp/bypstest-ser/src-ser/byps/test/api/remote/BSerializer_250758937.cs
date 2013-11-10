//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setPrimitiveTypes1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_250758937 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_250758937();
		
		public BSerializer_250758937()
			: base(250758937) {}
		
		public BSerializer_250758937(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setPrimitiveTypes1 obj = (BRequest_RemoteSetTypes_setPrimitiveTypes1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.primitiveTypes1Value, false, byps.test.api.BSerializer_673917574.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setPrimitiveTypes1 obj = (BRequest_RemoteSetTypes_setPrimitiveTypes1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setPrimitiveTypes1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.primitiveTypes1Value = (ISet<byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
