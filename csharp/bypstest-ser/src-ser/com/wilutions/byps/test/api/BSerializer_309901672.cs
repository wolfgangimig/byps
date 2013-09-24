//
// Serializer for com.wilutions.byps.test.api.BResult_16
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_309901672 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_309901672();
		
		public BSerializer_309901672()
			: base(309901672) {}
		
		public BSerializer_309901672(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_16 obj = (BResult_16)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_16 obj = (BResult_16)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_16()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (BRemote)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
