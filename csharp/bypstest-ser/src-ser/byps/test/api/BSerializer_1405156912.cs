//
// Serializer for byps.test.api.BResult_564008001
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1405156912 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1405156912();
		
		public BSerializer_1405156912()
			: base(1405156912) {}
		
		public BSerializer_1405156912(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_564008001 obj = (BResult_564008001)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_564008001 obj = (BResult_564008001)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_564008001()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (byps.test.api.ver.EvolveIF)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
