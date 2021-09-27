//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_setObj1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1407232218 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1407232218();
		
		public BSerializer_1407232218()
			: base(1407232218) {}
		
		public BSerializer_1407232218(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setObj1 obj = (BRequest_RemoteMapTypes_setObj1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.obj1Value, false, byps.test.api.BSerializer_1488550492.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setObj1 obj = (BRequest_RemoteMapTypes_setObj1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setObj1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.obj1Value = (IDictionary<String,Object>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
