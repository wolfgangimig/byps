//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getChar1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1319940748 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1319940748();
		
		public BSerializer_1319940748()
			: base(1319940748) {}
		
		public BSerializer_1319940748(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_getChar1 obj = (BRequest_RemoteListTypes_getChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_getChar1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
