//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DListList
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1097161578 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1097161578();
		
		public BSerializer_1097161578()
			: base(1097161578) {}
		
		public BSerializer_1097161578(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: pointListList */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteInlineInstance_setPoint2DListList obj = (BRequest_RemoteInlineInstance_setPoint2DListList)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._pointListList, false, com.wilutions.byps.test.api.BSerializer_1463615848.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_setPoint2DListList obj = (BRequest_RemoteInlineInstance_setPoint2DListList)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setPoint2DListList()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._pointListList = (IList<IList<com.wilutions.byps.test.api.inl.Point2D>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
