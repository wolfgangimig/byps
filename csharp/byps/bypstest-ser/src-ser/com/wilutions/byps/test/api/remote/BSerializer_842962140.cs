//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setPrimitiveTypes1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_842962140 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_842962140();
		
		public BSerializer_842962140()
			: base(842962140) {}
		
		public BSerializer_842962140(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: primitiveTypes1 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteMapTypes_setPrimitiveTypes1 obj = (BRequest_RemoteMapTypes_setPrimitiveTypes1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._primitiveTypes1, false, com.wilutions.byps.test.api.BSerializer_703065817.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setPrimitiveTypes1 obj = (BRequest_RemoteMapTypes_setPrimitiveTypes1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setPrimitiveTypes1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._primitiveTypes1 = (IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
