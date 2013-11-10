//
// Serializer for byps.test.api.inherit.Class2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_6002 : byps.test.api.inherit.BSerializer_6001 {
		
		public readonly static new BSerializer instance = new BSerializer_6002();
		
		public BSerializer_6002()
			: base(6002) {}
		
		public BSerializer_6002(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			base.write(obj1, bout1, version);			
			Class2 obj = (Class2)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putInt(obj.Int2);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Class2 obj = (Class2)(obj1 != null ? obj1 : bin.onObjectCreated(new Class2()));
			
			base.read(obj, bin1, version);			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Int2 = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
