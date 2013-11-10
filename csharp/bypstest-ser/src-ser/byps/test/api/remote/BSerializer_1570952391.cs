//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setFloat1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1570952391 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1570952391();
		
		public BSerializer_1570952391()
			: base(1570952391) {}
		
		public BSerializer_1570952391(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setFloat1 obj = (BRequest_RemoteListTypes_setFloat1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.float1Value, false, byps.test.api.BSerializer_1628501332.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setFloat1 obj = (BRequest_RemoteListTypes_setFloat1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setFloat1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.float1Value = (IList<float>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
