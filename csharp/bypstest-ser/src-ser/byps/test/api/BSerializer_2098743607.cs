//
// Serializer for byps.test.api.BResult_673917574
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_2098743607 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2098743607();
		
		public BSerializer_2098743607()
			: base(2098743607) {}
		
		public BSerializer_2098743607(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_673917574 obj = (BResult_673917574)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_673917574.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_673917574 obj = (BResult_673917574)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_673917574()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (ISet<byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
