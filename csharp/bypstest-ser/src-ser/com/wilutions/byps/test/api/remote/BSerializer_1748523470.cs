//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1748523470 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1748523470();
		
		public BSerializer_1748523470()
			: base(1748523470) {}
		
		public BSerializer_1748523470(int typeId)
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
			BRequest_RemoteArrayTypes23_sendArraysInt obj = (BRequest_RemoteArrayTypes23_sendArraysInt)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._arr2, false, com.wilutions.byps.test.api.BSerializer_1957744307.instance);
			bout.writeObj(obj._arr3, false, com.wilutions.byps.test.api.BSerializer_196606293.instance);
			bout.writeObj(obj._arr4, false, com.wilutions.byps.test.api.BSerializer_39910537.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysInt obj = (BRequest_RemoteArrayTypes23_sendArraysInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysInt()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._arr2 = (int[,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1957744307.instance);
			obj._arr3 = (int[,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_196606293.instance);
			obj._arr4 = (int[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_39910537.instance);
			
			return obj;
		}
		
	}
} // namespace
