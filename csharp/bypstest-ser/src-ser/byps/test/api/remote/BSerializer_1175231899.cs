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
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.arr2Value, true, byps.test.api.BSerializer_1995260457.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.arr3Value, true, byps.test.api.BSerializer_1889888075.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.arr4Value, true, byps.test.api.BSerializer_588723219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes23_sendArraysString obj = (BRequest_RemoteArrayTypes23_sendArraysString)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes23_sendArraysString()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.arr2Value = (String[,])bin.readObj(false, byps.test.api.BSerializer_1995260457.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.arr3Value = (String[,,])bin.readObj(false, byps.test.api.BSerializer_1889888075.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.arr4Value = (String[,,,])bin.readObj(false, byps.test.api.BSerializer_588723219.instance);
			
			return obj;
		}
		
	}
} // namespace
