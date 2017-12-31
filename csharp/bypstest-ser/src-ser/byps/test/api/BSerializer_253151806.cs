//
// Serializer for byps.test.api.BResult_2123584667
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_253151806 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_253151806();
		
		public BSerializer_253151806()
			: base(253151806) {}
		
		public BSerializer_253151806(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_2123584667 obj = (BResult_2123584667)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_2123584667.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_2123584667 obj = (BResult_2123584667)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_2123584667()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (IList<String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
