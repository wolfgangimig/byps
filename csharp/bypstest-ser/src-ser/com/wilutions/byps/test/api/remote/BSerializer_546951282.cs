//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DMap
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_546951282 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_546951282();
		
		public BSerializer_546951282()
			: base(546951282) {}
		
		public BSerializer_546951282(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: pointMap */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteInlineInstance_setPoint2DMap obj = (BRequest_RemoteInlineInstance_setPoint2DMap)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._pointMap, false, com.wilutions.byps.test.api.BSerializer_1851881336.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_setPoint2DMap obj = (BRequest_RemoteInlineInstance_setPoint2DMap)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DMap()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._pointMap = (IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
