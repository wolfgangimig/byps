//
// Serializer for com.wilutions.byps.test.api.inherit.Class3
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_6003 : BSerializer_6002 {
		
		public readonly static new BSerializer instance = new BSerializer_6003();
		
		public BSerializer_6003()
			: base(6003) {}
		
		public BSerializer_6003(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=24: int3 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			base.write(obj1, bout1, version);			
			Class3 obj = (Class3)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj.Int3);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			Class3 obj = (Class3)(obj1 != null ? obj1 : bin.onObjectCreated(new Class3()));
			
			base.read(obj, bin1, version);			
			BBufferBin bbuf = bin.bbuf;
			obj.Int3 = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
