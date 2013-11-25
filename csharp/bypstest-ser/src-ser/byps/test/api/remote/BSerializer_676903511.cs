//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_setLong1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_676903511 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_676903511();
		
		public BSerializer_676903511()
			: base(676903511) {}
		
		public BSerializer_676903511(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setLong1 obj = (BRequest_RemoteMapTypes_setLong1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.long1Value, false, byps.test.api.BSerializer_1973996106.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setLong1 obj = (BRequest_RemoteMapTypes_setLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setLong1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.long1Value = (IDictionary<short,long>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
