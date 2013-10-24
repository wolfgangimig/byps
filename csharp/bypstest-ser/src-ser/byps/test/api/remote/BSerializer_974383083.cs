//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_setBoolean1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_974383083 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_974383083();
		
		public BSerializer_974383083()
			: base(974383083) {}
		
		public BSerializer_974383083(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setBoolean1 obj = (BRequest_RemoteMapTypes_setBoolean1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._boolean1, false, byps.test.api.BSerializer_1279823631.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setBoolean1 obj = (BRequest_RemoteMapTypes_setBoolean1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setBoolean1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._boolean1 = (IDictionary<String,bool>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
