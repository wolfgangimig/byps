﻿//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getLong
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_2091295080 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2091295080();
		
		public BSerializer_2091295080()
			: base(2091295080) {}
		
		public BSerializer_2091295080(int typeId)
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
			BRequest_RemotePrimitiveTypes_getLong obj = (BRequest_RemotePrimitiveTypes_getLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getLong()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
