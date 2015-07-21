//
// Serializer for byps.test.api.comp.BRequest_IncompatibleChangeIF_changedReturnType
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.comp
{
	
	public class BSerializer_262583988 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_262583988();
		
		public BSerializer_262583988()
			: base(262583988) {}
		
		public BSerializer_262583988(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_IncompatibleChangeIF_changedReturnType obj = (BRequest_IncompatibleChangeIF_changedReturnType)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_IncompatibleChangeIF_changedReturnType()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
