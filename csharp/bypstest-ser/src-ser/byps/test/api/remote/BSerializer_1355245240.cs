//
// Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DArray4dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1355245240 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1355245240();
		
		public BSerializer_1355245240()
			: base(1355245240) {}
		
		public BSerializer_1355245240(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteInlineInstance_setPoint2DArray4dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray4dim)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._pointArray, false, byps.test.api.BSerializer_949340697.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_setPoint2DArray4dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray4dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DArray4dim()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._pointArray = (byps.test.api.inl.Point2D[,,,])bin.readObj(false, byps.test.api.BSerializer_949340697.instance);
			
			return obj;
		}
		
	}
} // namespace
