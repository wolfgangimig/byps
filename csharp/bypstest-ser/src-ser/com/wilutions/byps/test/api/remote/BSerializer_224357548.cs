//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DList
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_224357548 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_224357548();
		
		public BSerializer_224357548()
			: base(224357548) {}
		
		public BSerializer_224357548(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteInlineInstance_setPoint2DList obj = (BRequest_RemoteInlineInstance_setPoint2DList)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._pointList, false, com.wilutions.byps.test.api.BSerializer_172221196.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_setPoint2DList obj = (BRequest_RemoteInlineInstance_setPoint2DList)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DList()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._pointList = (IList<com.wilutions.byps.test.api.inl.Point2D>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
