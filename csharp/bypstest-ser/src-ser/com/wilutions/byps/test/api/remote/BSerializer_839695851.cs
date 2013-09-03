//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteWithAuthentication_login
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_839695851 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_839695851();
		
		public BSerializer_839695851()
			: base(839695851) {}
		
		public BSerializer_839695851(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: sess */ + 4			
			       /* pos=4: userName */ + 4			
			       /* pos=8: userPwd */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
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
			obj._sess = (com.wilutions.byps.test.api.auth.SessionInfo)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
