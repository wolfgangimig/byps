//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_add
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_362528512 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_362528512();
		
		public BSerializer_362528512()
			: base(362528512) {}
		
		public BSerializer_362528512(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_add obj = (BRequest_RemotePrimitiveTypes_add)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.aValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.bValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_add obj = (BRequest_RemotePrimitiveTypes_add)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_add()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.aValue = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.bValue = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
