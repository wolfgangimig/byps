//
// Serializer for com.wilutions.byps.test.api.ver.Evolve2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public class BSerializer_573592593 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_573592593();
		
		public BSerializer_573592593()
			: base(573592593) {}
		
		public BSerializer_573592593(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Evolve2 obj = (Evolve2)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj.N1);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Evolve2 obj = (Evolve2)(obj1 != null ? obj1 : bin.onObjectCreated(new Evolve2()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.N1 = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
