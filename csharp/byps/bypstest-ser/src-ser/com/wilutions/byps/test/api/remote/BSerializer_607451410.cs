//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysString
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_607451410 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_607451410();
		
		public BSerializer_607451410()
			: base(607451410) {}
		
		public BSerializer_607451410(int typeId)
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
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteArrayTypes23_sendArraysString obj = (BRequest_RemoteArrayTypes23_sendArraysString)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._arr2, true, com.wilutions.byps.test.api.BSerializer_1995260457.instance);
			bout.writeObj(obj._arr3, true, com.wilutions.byps.test.api.BSerializer_1889888075.instance);
			bout.writeObj(obj._arr4, true, com.wilutions.byps.test.api.BSerializer_588723219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysString obj = (BRequest_RemoteArrayTypes23_sendArraysString)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysString()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._arr2 = (String[,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1995260457.instance);
			obj._arr3 = (String[,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1889888075.instance);
			obj._arr4 = (String[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_588723219.instance);
			
			return obj;
		}
		
	}
} // namespace
