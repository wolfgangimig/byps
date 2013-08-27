//
// Serializer for com.wilutions.byps.test.api.cons.HebrewZ
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.cons
{
	
	public class BSerializer_1518668429 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1518668429();
		
		public BSerializer_1518668429()
			: base(1518668429) {}
		
		public BSerializer_1518668429(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: core */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			HebrewZ obj = (HebrewZ)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putString(obj.Core);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			HebrewZ obj = (HebrewZ)(obj1 != null ? obj1 : bin.onObjectCreated(new HebrewZ()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Core = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
