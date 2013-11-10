//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setDate1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1461676227 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1461676227();
		
		public BSerializer_1461676227()
			: base(1461676227) {}
		
		public BSerializer_1461676227(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setDate1 obj = (BRequest_RemoteSetTypes_setDate1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.obj1Value, false, byps.test.api.BSerializer_1097919350.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setDate1 obj = (BRequest_RemoteSetTypes_setDate1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setDate1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.obj1Value = (ISet<java.util.Date>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
