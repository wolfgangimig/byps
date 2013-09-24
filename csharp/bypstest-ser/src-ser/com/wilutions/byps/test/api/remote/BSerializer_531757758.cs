//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DArray1dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_531757758 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_531757758();
		
		public BSerializer_531757758()
			: base(531757758) {}
		
		public BSerializer_531757758(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteInlineInstance_setPoint2DArray1dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray1dim)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._pointArray, false, com.wilutions.byps.test.api.BSerializer_2049740106.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_setPoint2DArray1dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DArray1dim()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._pointArray = (com.wilutions.byps.test.api.inl.Point2D[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2049740106.instance);
			
			return obj;
		}
		
	}
} // namespace
