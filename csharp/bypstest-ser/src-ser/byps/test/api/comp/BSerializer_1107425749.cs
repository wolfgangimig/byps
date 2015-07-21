//
// Serializer for byps.test.api.comp.IncompatibleChangeInfo
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.comp
{
	
	public class BSerializer_1107425749 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1107425749();
		
		public BSerializer_1107425749()
			: base(1107425749) {}
		
		public BSerializer_1107425749(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			IncompatibleChangeInfo obj = (IncompatibleChangeInfo)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.IntValueChangedToString);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			IncompatibleChangeInfo obj = (IncompatibleChangeInfo)(obj1 != null ? obj1 : bin.onObjectCreated(new IncompatibleChangeInfo()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.IntValueChangedToString = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
