//
// Serializer for byps.test.api.BResult_1375035164
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1920161159 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1920161159();
		
		public BSerializer_1920161159()
			: base(1920161159) {}
		
		public BSerializer_1920161159(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1375035164 obj = (BResult_1375035164)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt((int)obj._result);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1375035164 obj = (BResult_1375035164)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1375035164()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (byps.test.api.enu.EnumPlanets)bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
