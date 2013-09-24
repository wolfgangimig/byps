//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setPrimitiveTypes1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1572111902 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1572111902();
		
		public BSerializer_1572111902()
			: base(1572111902) {}
		
		public BSerializer_1572111902(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setPrimitiveTypes1 obj = (BRequest_RemoteSetTypes_setPrimitiveTypes1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._primitiveTypes1, false, com.wilutions.byps.test.api.BSerializer_1280571537.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setPrimitiveTypes1 obj = (BRequest_RemoteSetTypes_setPrimitiveTypes1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setPrimitiveTypes1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._primitiveTypes1 = (ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
