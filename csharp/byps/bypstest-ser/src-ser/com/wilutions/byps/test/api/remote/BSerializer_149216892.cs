//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setShort
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_149216892 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_149216892();
		
		public BSerializer_149216892()
			: base(149216892) {}
		
		public BSerializer_149216892(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: v */ + 2			
			       /* padding up to multiple of alignment */ + 6;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemotePrimitiveTypes_setShort obj = (BRequest_RemotePrimitiveTypes_setShort)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putShort(obj._v);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_setShort obj = (BRequest_RemotePrimitiveTypes_setShort)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setShort()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = bbuf.getShort();
			
			return obj;
		}
		
	}
} // namespace
