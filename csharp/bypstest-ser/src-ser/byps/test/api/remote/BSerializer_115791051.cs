﻿//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_getLong1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_115791051 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_115791051();
		
		public BSerializer_115791051()
			: base(115791051) {}
		
		public BSerializer_115791051(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_getLong1 obj = (BRequest_RemoteMapTypes_getLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_getLong1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
