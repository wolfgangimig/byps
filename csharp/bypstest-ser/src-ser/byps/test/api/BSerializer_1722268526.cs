//
// Serializer for byps.test.api.BResult_1391985860
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1722268526 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1722268526();
		
		public BSerializer_1722268526()
			: base(1722268526) {}
		
		public BSerializer_1722268526(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1391985860 obj = (BResult_1391985860)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1391985860 obj = (BResult_1391985860)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1391985860()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (byps.test.api.ver.Evolve)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
