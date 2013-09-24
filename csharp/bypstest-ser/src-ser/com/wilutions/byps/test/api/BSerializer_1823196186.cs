//
// Serializer for com.wilutions.byps.test.api.BResult_1746702954
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1823196186 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1823196186();
		
		public BSerializer_1823196186()
			: base(1823196186) {}
		
		public BSerializer_1823196186(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1746702954 obj = (BResult_1746702954)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_1746702954.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1746702954 obj = (BResult_1746702954)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1746702954()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (IList<IList<int>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
