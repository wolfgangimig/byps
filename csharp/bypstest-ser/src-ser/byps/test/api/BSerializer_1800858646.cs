//
// Serializer for byps.test.api.BResult_94341197
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1800858646 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1800858646();
		
		public BSerializer_1800858646()
			: base(1800858646) {}
		
		public BSerializer_1800858646(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_94341197 obj = (BResult_94341197)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_94341197.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_94341197 obj = (BResult_94341197)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_94341197()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.resultValue = (IDictionary<char,float>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
