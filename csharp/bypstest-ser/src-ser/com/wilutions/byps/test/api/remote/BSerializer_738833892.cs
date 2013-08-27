//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysObject
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_738833892 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_738833892();
		
		public BSerializer_738833892()
			: base(738833892) {}
		
		public BSerializer_738833892(int typeId)
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
			BRequest_RemoteArrayTypes23_sendArraysObject obj = (BRequest_RemoteArrayTypes23_sendArraysObject)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._arr2, false, com.wilutions.byps.test.api.BSerializer_340213335.instance);
			bout.writeObj(obj._arr3, false, com.wilutions.byps.test.api.BSerializer_527503353.instance);
			bout.writeObj(obj._arr4, false, com.wilutions.byps.test.api.BSerializer_124584219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysObject obj = (BRequest_RemoteArrayTypes23_sendArraysObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysObject()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._arr2 = (Object[,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_340213335.instance);
			obj._arr3 = (Object[,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_527503353.instance);
			obj._arr4 = (Object[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_124584219.instance);
			
			return obj;
		}
		
	}
} // namespace
