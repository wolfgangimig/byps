//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysObject
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1306614381 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1306614381();
		
		public BSerializer_1306614381()
			: base(1306614381) {}
		
		public BSerializer_1306614381(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes23_sendArraysObject obj = (BRequest_RemoteArrayTypes23_sendArraysObject)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._arr2, false, byps.test.api.BSerializer_340213335.instance);
			bout.writeObj(obj._arr3, false, byps.test.api.BSerializer_527503353.instance);
			bout.writeObj(obj._arr4, false, byps.test.api.BSerializer_124584219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysObject obj = (BRequest_RemoteArrayTypes23_sendArraysObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysObject()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._arr2 = (Object[,])bin.readObj(false, byps.test.api.BSerializer_340213335.instance);
			obj._arr3 = (Object[,,])bin.readObj(false, byps.test.api.BSerializer_527503353.instance);
			obj._arr4 = (Object[,,,])bin.readObj(false, byps.test.api.BSerializer_124584219.instance);
			
			return obj;
		}
		
	}
} // namespace
