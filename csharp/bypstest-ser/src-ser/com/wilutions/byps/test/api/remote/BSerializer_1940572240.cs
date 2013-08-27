//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getPrimitiveTypes1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1940572240 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1940572240();
		
		public BSerializer_1940572240()
			: base(1940572240) {}
		
		public BSerializer_1940572240(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_getPrimitiveTypes1 obj = (BRequest_RemoteListTypes_getPrimitiveTypes1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_getPrimitiveTypes1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
