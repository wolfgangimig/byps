//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setShort
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1951707614 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1951707614();
		
		public BSerializer_1951707614()
			: base(1951707614) {}
		
		public BSerializer_1951707614(int typeId)
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
			BRequest_RemoteArrayTypes4dim_setShort obj = (BRequest_RemoteArrayTypes4dim_setShort)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, com.wilutions.byps.test.api.BSerializer_1859644668.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setShort obj = (BRequest_RemoteArrayTypes4dim_setShort)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setShort()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (short[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1859644668.instance);
			
			return obj;
		}
		
	}
} // namespace
