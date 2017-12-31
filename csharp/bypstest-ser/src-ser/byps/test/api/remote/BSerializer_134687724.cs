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
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.userNameValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.userPwdValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.sessValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteWithAuthentication_login obj = (BRequest_RemoteWithAuthentication_login)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteWithAuthentication_login()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.userNameValue = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.userPwdValue = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.sessValue = (byps.test.api.auth.SessionInfo)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
