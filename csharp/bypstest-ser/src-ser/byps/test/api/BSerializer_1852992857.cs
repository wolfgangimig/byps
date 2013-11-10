//
// Serializer for byps.test.api.BResult_945713488
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1852992857 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1852992857();
		
		public BSerializer_1852992857()
			: base(1852992857) {}
		
		public BSerializer_1852992857(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_945713488 obj = (BResult_945713488)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_945713488.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_945713488 obj = (BResult_945713488)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_945713488()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.resultValue = (bool[,,,])bin.readObj(false, byps.test.api.BSerializer_945713488.instance);
			
			return obj;
		}
		
	}
} // namespace
