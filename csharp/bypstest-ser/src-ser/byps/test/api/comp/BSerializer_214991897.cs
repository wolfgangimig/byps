//
// Serializer for byps.test.api.comp.BRequest_IncompatibleChangeIF_changedParameterType
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.comp
{
	
	public class BSerializer_214991897 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_214991897();
		
		public BSerializer_214991897()
			: base(214991897) {}
		
		public BSerializer_214991897(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_IncompatibleChangeIF_changedParameterType obj = (BRequest_IncompatibleChangeIF_changedParameterType)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.intParamChangedToStringValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_IncompatibleChangeIF_changedParameterType obj = (BRequest_IncompatibleChangeIF_changedParameterType)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_IncompatibleChangeIF_changedParameterType()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.intParamChangedToStringValue = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
