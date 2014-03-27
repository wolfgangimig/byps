//
// Serializer for byps.test.api.BResult_31512998
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1620912700 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1620912700();
		
		public BSerializer_1620912700()
			: base(1620912700) {}
		
		public BSerializer_1620912700(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_31512998 obj = (BResult_31512998)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_31512998.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_31512998 obj = (BResult_31512998)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_31512998()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (HashSet<byte>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
