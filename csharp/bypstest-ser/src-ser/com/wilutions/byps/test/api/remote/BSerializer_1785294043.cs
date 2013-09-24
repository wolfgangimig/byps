//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteWithAuthentication_setUseAuthentication
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1785294043 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1785294043();
		
		public BSerializer_1785294043()
			: base(1785294043) {}
		
		public BSerializer_1785294043(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteWithAuthentication_setUseAuthentication obj = (BRequest_RemoteWithAuthentication_setUseAuthentication)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putBoolean(obj._useAuth);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteWithAuthentication_setUseAuthentication obj = (BRequest_RemoteWithAuthentication_setUseAuthentication)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteWithAuthentication_setUseAuthentication()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._useAuth = bbuf.getBoolean();
			
			return obj;
		}
		
	}
} // namespace
