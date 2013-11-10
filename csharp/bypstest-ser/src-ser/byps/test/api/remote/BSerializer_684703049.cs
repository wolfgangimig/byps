//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_setDate1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_684703049 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_684703049();
		
		public BSerializer_684703049()
			: base(684703049) {}
		
		public BSerializer_684703049(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setDate1 obj = (BRequest_RemoteMapTypes_setDate1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.obj1Value, false, byps.test.api.BSerializer_1366799209.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setDate1 obj = (BRequest_RemoteMapTypes_setDate1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setDate1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.obj1Value = (IDictionary<String,DateTime>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
