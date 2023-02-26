//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1828268517 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1828268517();
		
		public BSerializer_1828268517()
			: base(1828268517) {}
		
		public BSerializer_1828268517(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes23_sendArraysInt obj = (BRequest_RemoteArrayTypes23_sendArraysInt)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.arr2Value, false, byps.test.api.BSerializer_1957744307.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.arr3Value, false, byps.test.api.BSerializer_196606293.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.arr4Value, false, byps.test.api.BSerializer_39910537.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysInt obj = (BRequest_RemoteArrayTypes23_sendArraysInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysInt()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.arr2Value = (int[,])bin.readObj(false, byps.test.api.BSerializer_1957744307.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.arr3Value = (int[,,])bin.readObj(false, byps.test.api.BSerializer_196606293.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.arr4Value = (int[,,,])bin.readObj(false, byps.test.api.BSerializer_39910537.instance);
			
			return obj;
		}
		
	}
} // namespace
