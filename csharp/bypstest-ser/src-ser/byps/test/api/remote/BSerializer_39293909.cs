﻿//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getDouble
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_39293909 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_39293909();
		
		public BSerializer_39293909()
			: base(39293909) {}
		
		public BSerializer_39293909(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_getDouble obj = (BRequest_RemoteArrayTypes1dim_getDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_getDouble()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
