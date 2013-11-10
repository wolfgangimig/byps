//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setInt2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_462631447 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_462631447();
		
		public BSerializer_462631447()
			: base(462631447) {}
		
		public BSerializer_462631447(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setInt2 obj = (BRequest_RemoteSetTypes_setInt2)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.int2Value, false, byps.test.api.BSerializer_1406124761.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setInt2 obj = (BRequest_RemoteSetTypes_setInt2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setInt2()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.int2Value = (ISet<int[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
