//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getChar
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_2033439280 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2033439280();
		
		public BSerializer_2033439280()
			: base(2033439280) {}
		
		public BSerializer_2033439280(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_getChar obj = (BRequest_RemoteArrayTypes1dim_getChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_getChar()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
