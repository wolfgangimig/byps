//
// Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_setActor
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1162005320 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1162005320();
		
		public BSerializer_1162005320()
			: base(1162005320) {}
		
		public BSerializer_1162005320(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteInlineInstance_setActor obj = (BRequest_RemoteInlineInstance_setActor)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._act, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_setActor obj = (BRequest_RemoteInlineInstance_setActor)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setActor()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._act = (byps.test.api.inl.Actor)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
