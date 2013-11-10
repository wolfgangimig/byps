//
// Serializer for byps.test.api.remote.BRequest_RemoteWithAuthentication_expire
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_72176172 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_72176172();
		
		public BSerializer_72176172()
			: base(72176172) {}
		
		public BSerializer_72176172(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteWithAuthentication_expire obj = (BRequest_RemoteWithAuthentication_expire)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.sessValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteWithAuthentication_expire obj = (BRequest_RemoteWithAuthentication_expire)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteWithAuthentication_expire()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.sessValue = (byps.test.api.auth.SessionInfo)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
