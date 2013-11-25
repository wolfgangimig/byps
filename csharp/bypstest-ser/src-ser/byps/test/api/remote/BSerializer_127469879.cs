//
// Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DMap
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_127469879 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_127469879();
		
		public BSerializer_127469879()
			: base(127469879) {}
		
		public BSerializer_127469879(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteInlineInstance_setPoint2DMap obj = (BRequest_RemoteInlineInstance_setPoint2DMap)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.pointMapValue, false, byps.test.api.BSerializer_1358523233.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_setPoint2DMap obj = (BRequest_RemoteInlineInstance_setPoint2DMap)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DMap()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.pointMapValue = (IDictionary<int,byps.test.api.inl.Point2D>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
