//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getChar1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_2125285334 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2125285334();
		
		public BSerializer_2125285334()
			: base(2125285334) {}
		
		public BSerializer_2125285334(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_getChar1 obj = (BRequest_RemoteSetTypes_getChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_getChar1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
