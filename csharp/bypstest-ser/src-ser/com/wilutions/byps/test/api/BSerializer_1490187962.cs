//
// Serializer for com.wilutions.byps.test.api.BResult_487702928
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1490187962 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1490187962();
		
		public BSerializer_1490187962()
			: base(1490187962) {}
		
		public BSerializer_1490187962(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_487702928 obj = (BResult_487702928)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_487702928.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_487702928 obj = (BResult_487702928)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_487702928()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (com.wilutions.byps.test.api.inl.Point2D[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_487702928.instance);
			
			return obj;
		}
		
	}
} // namespace
