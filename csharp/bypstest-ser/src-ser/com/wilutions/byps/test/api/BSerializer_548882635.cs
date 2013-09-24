//
// Serializer for com.wilutions.byps.test.api.BResult_1463615848
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_548882635 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_548882635();
		
		public BSerializer_548882635()
			: base(548882635) {}
		
		public BSerializer_548882635(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1463615848 obj = (BResult_1463615848)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_1463615848.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1463615848 obj = (BResult_1463615848)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1463615848()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (IList<IList<com.wilutions.byps.test.api.inl.Point2D>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
