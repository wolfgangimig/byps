//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysClass
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1004457221 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1004457221();
		
		public BSerializer_1004457221()
			: base(1004457221) {}
		
		public BSerializer_1004457221(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: arr2 */ + 4			
			       /* pos=4: arr3 */ + 4			
			       /* pos=8: arr4 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes23_sendArraysClass obj = (BRequest_RemoteArrayTypes23_sendArraysClass)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._arr2, false, com.wilutions.byps.test.api.BSerializer_1195496149.instance);
			bout.writeObj(obj._arr3, false, com.wilutions.byps.test.api.BSerializer_2115528243.instance);
			bout.writeObj(obj._arr4, false, com.wilutions.byps.test.api.BSerializer_1503107601.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysClass obj = (BRequest_RemoteArrayTypes23_sendArraysClass)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysClass()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._arr2 = (com.wilutions.byps.test.api.prim.PrimitiveTypes[,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1195496149.instance);
			obj._arr3 = (com.wilutions.byps.test.api.prim.PrimitiveTypes[,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2115528243.instance);
			obj._arr4 = (com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1503107601.instance);
			
			return obj;
		}
		
	}
} // namespace
