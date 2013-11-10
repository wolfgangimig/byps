//
// Serializer for byps.test.api.remote.BRequest_RemoteWithAuthentication_setUseAuthentication
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_946544530 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_946544530();
		
		public BSerializer_946544530()
			: base(946544530) {}
		
		public BSerializer_946544530(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteWithAuthentication_setUseAuthentication obj = (BRequest_RemoteWithAuthentication_setUseAuthentication)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putBoolean(obj.useAuthValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteWithAuthentication_setUseAuthentication obj = (BRequest_RemoteWithAuthentication_setUseAuthentication)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteWithAuthentication_setUseAuthentication()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.useAuthValue = bbuf.getBoolean();
			
			return obj;
		}
		
	}
} // namespace
