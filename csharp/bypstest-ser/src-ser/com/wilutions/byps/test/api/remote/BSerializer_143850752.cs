//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setByte
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_143850752 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_143850752();
		
		public BSerializer_143850752()
			: base(143850752) {}
		
		public BSerializer_143850752(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: v */ + 1			
			       /* padding up to multiple of alignment */ + 7;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_setByte obj = (BRequest_RemotePrimitiveTypes_setByte)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putByte(obj._v);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_setByte obj = (BRequest_RemotePrimitiveTypes_setByte)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setByte()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = bbuf.getByte();
			
			return obj;
		}
		
	}
} // namespace
