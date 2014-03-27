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
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.arr2Value, false, byps.test.api.BSerializer_340213335.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.arr3Value, false, byps.test.api.BSerializer_527503353.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.arr4Value, false, byps.test.api.BSerializer_124584219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysObject obj = (BRequest_RemoteArrayTypes23_sendArraysObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysObject()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.arr2Value = (Object[,])bin.readObj(false, byps.test.api.BSerializer_340213335.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.arr3Value = (Object[,,])bin.readObj(false, byps.test.api.BSerializer_527503353.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.arr4Value = (Object[,,,])bin.readObj(false, byps.test.api.BSerializer_124584219.instance);
			
			return obj;
		}
		
	}
} // namespace
