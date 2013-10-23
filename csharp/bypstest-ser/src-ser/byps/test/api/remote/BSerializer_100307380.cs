//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_setString1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_100307380 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_100307380();
		
		public BSerializer_100307380()
			: base(100307380) {}
		
		public BSerializer_100307380(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setString1 obj = (BRequest_RemoteMapTypes_setString1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._string1, false, byps.test.api.BSerializer_1710660846.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setString1 obj = (BRequest_RemoteMapTypes_setString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setString1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._string1 = (IDictionary<String,String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
