//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysInline
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_899462794 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_899462794();
		
		public BSerializer_899462794()
			: base(899462794) {}
		
		public BSerializer_899462794(int typeId)
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
			BRequest_RemoteArrayTypes23_sendArraysInline obj = (BRequest_RemoteArrayTypes23_sendArraysInline)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._arr2, false, com.wilutions.byps.test.api.BSerializer_1589744084.instance);
			bout.writeObj(obj._arr3, false, com.wilutions.byps.test.api.BSerializer_1264295566.instance);
			bout.writeObj(obj._arr4, false, com.wilutions.byps.test.api.BSerializer_487702928.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysInline obj = (BRequest_RemoteArrayTypes23_sendArraysInline)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysInline()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._arr2 = (com.wilutions.byps.test.api.inl.Point2D[,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1589744084.instance);
			obj._arr3 = (com.wilutions.byps.test.api.inl.Point2D[,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1264295566.instance);
			obj._arr4 = (com.wilutions.byps.test.api.inl.Point2D[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_487702928.instance);
			
			return obj;
		}
		
	}
} // namespace
