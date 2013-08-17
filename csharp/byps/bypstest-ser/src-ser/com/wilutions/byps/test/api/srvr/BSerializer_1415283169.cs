//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getStreamsFromClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_1415283169 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1415283169();
		
		public BSerializer_1415283169()
			: base(1415283169) {}
		
		public BSerializer_1415283169(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_getStreamsFromClient obj = (BRequest_ServerIF_getStreamsFromClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_getStreamsFromClient()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
