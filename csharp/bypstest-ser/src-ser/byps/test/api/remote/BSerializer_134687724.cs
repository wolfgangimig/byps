//
// Serializer for byps.test.api.remote.BRequest_RemoteWithAuthentication_login
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_134687724 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_134687724();
		
		public BSerializer_134687724()
			: base(134687724) {}
		
		public BSerializer_134687724(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteWithAuthentication_login obj = (BRequest_RemoteWithAuthentication_login)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putString(obj._userName);
			bbuf.putString(obj._userPwd);
			bout.writeObj(obj._sess, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteWithAuthentication_login obj = (BRequest_RemoteWithAuthentication_login)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteWithAuthentication_login()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._userName = bbuf.getString();
			obj._userPwd = bbuf.getString();
			obj._sess = (byps.test.api.auth.SessionInfo)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
