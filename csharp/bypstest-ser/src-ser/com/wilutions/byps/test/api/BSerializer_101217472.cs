//
// Serializer for com.wilutions.byps.test.api.BResult_1859644668
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_101217472 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_101217472();
		
		public BSerializer_101217472()
			: base(101217472) {}
		
		public BSerializer_101217472(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1859644668 obj = (BResult_1859644668)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_1859644668.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1859644668 obj = (BResult_1859644668)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1859644668()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (short[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1859644668.instance);
			
			return obj;
		}
		
	}
} // namespace
