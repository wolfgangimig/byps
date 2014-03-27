//
// Serializer for byps.test.api.remote.BRequest_RemoteWithAuthentication_setReloginCount
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_802968058 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_802968058();
		
		public BSerializer_802968058()
			: base(802968058) {}
		
		public BSerializer_802968058(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteWithAuthentication_setReloginCount obj = (BRequest_RemoteWithAuthentication_setReloginCount)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.countValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteWithAuthentication_setReloginCount obj = (BRequest_RemoteWithAuthentication_setReloginCount)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteWithAuthentication_setReloginCount()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.countValue = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
