//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_add
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1073583639 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1073583639();
		
		public BSerializer_1073583639()
			: base(1073583639) {}
		
		public BSerializer_1073583639(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_add obj = (BRequest_RemotePrimitiveTypes_add)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._a);
			bbuf.putInt(obj._b);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_add obj = (BRequest_RemotePrimitiveTypes_add)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_add()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._a = bbuf.getInt();
			obj._b = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
