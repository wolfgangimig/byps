//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setInt3
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_136821226 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_136821226();
		
		public BSerializer_136821226()
			: base(136821226) {}
		
		public BSerializer_136821226(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setInt3 obj = (BRequest_RemoteListTypes_setInt3)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.int3Value, false, byps.test.api.BSerializer_1746702954.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setInt3 obj = (BRequest_RemoteListTypes_setInt3)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setInt3()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.int3Value = (IList<IList<int>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
