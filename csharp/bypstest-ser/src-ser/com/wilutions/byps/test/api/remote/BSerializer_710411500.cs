//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setPrimitiveTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_710411500 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_710411500();
		
		public BSerializer_710411500()
			: base(710411500) {}
		
		public BSerializer_710411500(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: v */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes4dim_setPrimitiveTypes obj = (BRequest_RemoteArrayTypes4dim_setPrimitiveTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, com.wilutions.byps.test.api.BSerializer_1503107601.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setPrimitiveTypes obj = (BRequest_RemoteArrayTypes4dim_setPrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setPrimitiveTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1503107601.instance);
			
			return obj;
		}
		
	}
} // namespace
