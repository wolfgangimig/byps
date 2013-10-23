//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysString
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1175231899 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1175231899();
		
		public BSerializer_1175231899()
			: base(1175231899) {}
		
		public BSerializer_1175231899(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes23_sendArraysString obj = (BRequest_RemoteArrayTypes23_sendArraysString)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._arr2, true, byps.test.api.BSerializer_1995260457.instance);
			bout.writeObj(obj._arr3, true, byps.test.api.BSerializer_1889888075.instance);
			bout.writeObj(obj._arr4, true, byps.test.api.BSerializer_588723219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysString obj = (BRequest_RemoteArrayTypes23_sendArraysString)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysString()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._arr2 = (String[,])bin.readObj(false, byps.test.api.BSerializer_1995260457.instance);
			obj._arr3 = (String[,,])bin.readObj(false, byps.test.api.BSerializer_1889888075.instance);
			obj._arr4 = (String[,,,])bin.readObj(false, byps.test.api.BSerializer_588723219.instance);
			
			return obj;
		}
		
	}
} // namespace
