//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DArray4dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_531668385 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_531668385();
		
		public BSerializer_531668385()
			: base(531668385) {}
		
		public BSerializer_531668385(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: pointArray */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteInlineInstance_setPoint2DArray4dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray4dim)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._pointArray, false, com.wilutions.byps.test.api.BSerializer_487702928.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_setPoint2DArray4dim obj = (BRequest_RemoteInlineInstance_setPoint2DArray4dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DArray4dim()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._pointArray = (com.wilutions.byps.test.api.inl.Point2D[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_487702928.instance);
			
			return obj;
		}
		
	}
} // namespace
