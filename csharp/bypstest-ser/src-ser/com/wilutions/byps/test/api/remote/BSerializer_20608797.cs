//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteWithAuthentication_setReloginCount
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_20608797 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_20608797();
		
		public BSerializer_20608797()
			: base(20608797) {}
		
		public BSerializer_20608797(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: count */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteWithAuthentication_setReloginCount obj = (BRequest_RemoteWithAuthentication_setReloginCount)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._count);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteWithAuthentication_setReloginCount obj = (BRequest_RemoteWithAuthentication_setReloginCount)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteWithAuthentication_setReloginCount()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._count = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
