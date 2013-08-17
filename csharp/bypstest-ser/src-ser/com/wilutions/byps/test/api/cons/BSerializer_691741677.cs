//
// Serializer for com.wilutions.byps.test.api.cons.HebrewC
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.cons
{
	
	public class BSerializer_691741677 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_691741677();
		
		public BSerializer_691741677()
			: base(691741677) {}
		
		public BSerializer_691741677(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: aleph */ + 4			
			       /* pos=4: beth */ + 4			
			       /* pos=8: ALEPH */ + 4			
			       /* pos=12: BETH */ + 4			
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			HebrewC obj = (HebrewC)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			HebrewC obj = (HebrewC)(obj1 != null ? obj1 : bin.onObjectCreated(new HebrewC()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
