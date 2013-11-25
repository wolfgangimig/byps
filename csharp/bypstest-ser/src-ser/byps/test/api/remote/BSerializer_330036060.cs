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
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.arr2Value, false, byps.test.api.BSerializer_2030857950.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.arr3Value, false, byps.test.api.BSerializer_1739334652.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.arr4Value, false, byps.test.api.BSerializer_758319514.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysClass obj = (BRequest_RemoteArrayTypes23_sendArraysClass)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysClass()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.arr2Value = (byps.test.api.prim.PrimitiveTypes[,])bin.readObj(false, byps.test.api.BSerializer_2030857950.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.arr3Value = (byps.test.api.prim.PrimitiveTypes[,,])bin.readObj(false, byps.test.api.BSerializer_1739334652.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.arr4Value = (byps.test.api.prim.PrimitiveTypes[,,,])bin.readObj(false, byps.test.api.BSerializer_758319514.instance);
			
			return obj;
		}
		
	}
} // namespace
