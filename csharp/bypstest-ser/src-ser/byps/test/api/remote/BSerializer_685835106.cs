//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_setByte2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_685835106 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_685835106();
		
		public BSerializer_685835106()
			: base(685835106) {}
		
		public BSerializer_685835106(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setByte2 obj = (BRequest_RemoteMapTypes_setByte2)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.byte2Value, false, byps.test.api.BSerializer_1799280818.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setByte2 obj = (BRequest_RemoteMapTypes_setByte2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setByte2()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.byte2Value = (IDictionary<int,byte[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
