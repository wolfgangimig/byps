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
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			HebrewC obj = (HebrewC)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			HebrewC obj = (HebrewC)(obj1 != null ? obj1 : bin.onObjectCreated(new HebrewC()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
