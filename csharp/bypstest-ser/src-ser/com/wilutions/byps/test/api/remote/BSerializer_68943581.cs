//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteWithAuthentication_expire
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_68943581 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_68943581();
		
		public BSerializer_68943581()
			: base(68943581) {}
		
		public BSerializer_68943581(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteWithAuthentication_expire obj = (BRequest_RemoteWithAuthentication_expire)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._sess, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteWithAuthentication_expire obj = (BRequest_RemoteWithAuthentication_expire)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteWithAuthentication_expire()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._sess = (com.wilutions.byps.test.api.auth.SessionInfo)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
