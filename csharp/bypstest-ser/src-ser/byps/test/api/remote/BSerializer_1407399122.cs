//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_setInt1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1407399122 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1407399122();
		
		public BSerializer_1407399122()
			: base(1407399122) {}
		
		public BSerializer_1407399122(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setInt1 obj = (BRequest_RemoteMapTypes_setInt1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.int1Value, false, byps.test.api.BSerializer_1347703734.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setInt1 obj = (BRequest_RemoteMapTypes_setInt1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setInt1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.int1Value = (IDictionary<int,int>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
