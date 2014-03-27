//
// Serializer for byps.test.api.inherit.Class3
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_6003 : byps.test.api.inherit.BSerializer_6002 {
		
		public readonly static new BSerializer instance = new BSerializer_6003();
		
		public BSerializer_6003()
			: base(6003) {}
		
		public BSerializer_6003(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			base.write(obj1, bout1, version);			
			Class3 obj = (Class3)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.Int3);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Class3 obj = (Class3)(obj1 != null ? obj1 : bin.onObjectCreated(new Class3()));
			
			base.read(obj, bin1, version);			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Int3 = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
