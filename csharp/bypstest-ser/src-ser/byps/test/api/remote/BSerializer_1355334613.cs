//
// Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DArray1dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1355334613 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1355334613();
		
		public BSerializer_1355334613()
			: base(1355334613) {}
		
		public BSerializer_1355334613(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteInlineInstance_setPoint2DArray1dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray1dim)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.pointArrayValue, false, byps.test.api.BSerializer_184101377.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_setPoint2DArray1dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DArray1dim()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.pointArrayValue = (byps.test.api.inl.Point2D[])bin.readObj(false, byps.test.api.BSerializer_184101377.instance);
			
			return obj;
		}
		
	}
} // namespace
