//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysClass
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_330036060 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_330036060();
		
		public BSerializer_330036060()
			: base(330036060) {}
		
		public BSerializer_330036060(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes23_sendArraysClass obj = (BRequest_RemoteArrayTypes23_sendArraysClass)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._arr2, false, byps.test.api.BSerializer_2030857950.instance);
			bout.writeObj(obj._arr3, false, byps.test.api.BSerializer_1739334652.instance);
			bout.writeObj(obj._arr4, false, byps.test.api.BSerializer_758319514.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysClass obj = (BRequest_RemoteArrayTypes23_sendArraysClass)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysClass()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._arr2 = (byps.test.api.prim.PrimitiveTypes[,])bin.readObj(false, byps.test.api.BSerializer_2030857950.instance);
			obj._arr3 = (byps.test.api.prim.PrimitiveTypes[,,])bin.readObj(false, byps.test.api.BSerializer_1739334652.instance);
			obj._arr4 = (byps.test.api.prim.PrimitiveTypes[,,,])bin.readObj(false, byps.test.api.BSerializer_758319514.instance);
			
			return obj;
		}
		
	}
} // namespace
