//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DList
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1996093752 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1996093752();
		
		public BSerializer_1996093752()
			: base(1996093752) {}
		
		public BSerializer_1996093752(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_getPoint2DList obj = (BRequest_RemoteInlineInstance_getPoint2DList)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getPoint2DList()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
