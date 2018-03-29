//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_setObject
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1425359520 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1425359520();
		
		public BSerializer_1425359520()
			: base(1425359520) {}
		
		public BSerializer_1425359520(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_setObject obj = (BRequest_RemotePrimitiveTypes_setObject)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.vValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_setObject obj = (BRequest_RemotePrimitiveTypes_setObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setObject()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.vValue = (Object)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
