//
// Serializer for com.wilutions.byps.test.api.BResult_12
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_309901676 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_309901676();
		
		public BSerializer_309901676()
			: base(309901676) {}
		
		public BSerializer_309901676(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_12 obj = (BResult_12)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.BSerializer_12.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_12 obj = (BResult_12)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_12()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (IList<Object>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
