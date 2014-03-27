//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_setChar
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_243974583 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_243974583();
		
		public BSerializer_243974583()
			: base(243974583) {}
		
		public BSerializer_243974583(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_setChar obj = (BRequest_RemotePrimitiveTypes_setChar)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putChar(obj.vValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_setChar obj = (BRequest_RemotePrimitiveTypes_setChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setChar()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.vValue = bbuf.getChar();
			
			return obj;
		}
		
	}
} // namespace
