//
// Serializer for byps.test.api.BResult_1279823631
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_629604454 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_629604454();
		
		public BSerializer_629604454()
			: base(629604454) {}
		
		public BSerializer_629604454(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1279823631 obj = (BResult_1279823631)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1279823631.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1279823631 obj = (BResult_1279823631)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1279823631()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.resultValue = (IDictionary<String,bool>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
