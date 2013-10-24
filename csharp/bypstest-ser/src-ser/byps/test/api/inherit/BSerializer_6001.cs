//
// Serializer for byps.test.api.inherit.Class1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_6001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_6001();
		
		public BSerializer_6001()
			: base(6001) {}
		
		public BSerializer_6001(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Class1 obj = (Class1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj.Int1);
			bout.writeObj(obj.NextClass1, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Class1 obj = (Class1)(obj1 != null ? obj1 : bin.onObjectCreated(new Class1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Int1 = bbuf.getInt();
			obj.NextClass1 = (byps.test.api.inherit.Class1)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
