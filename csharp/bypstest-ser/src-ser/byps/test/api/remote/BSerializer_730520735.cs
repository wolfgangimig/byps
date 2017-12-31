//
// Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DListList
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_730520735 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_730520735();
		
		public BSerializer_730520735()
			: base(730520735) {}
		
		public BSerializer_730520735(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteInlineInstance_setPoint2DListList obj = (BRequest_RemoteInlineInstance_setPoint2DListList)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.pointListListValue, false, byps.test.api.BSerializer_1823330785.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_setPoint2DListList obj = (BRequest_RemoteInlineInstance_setPoint2DListList)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DListList()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.pointListListValue = (IList<IList<byps.test.api.inl.Point2D>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
