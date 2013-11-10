//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setDouble1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_185153786 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_185153786();
		
		public BSerializer_185153786()
			: base(185153786) {}
		
		public BSerializer_185153786(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteSetTypes_setDouble1 obj = (BRequest_RemoteSetTypes_setDouble1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.double1Value, false, byps.test.api.BSerializer_1320560671.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setDouble1 obj = (BRequest_RemoteSetTypes_setDouble1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setDouble1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.double1Value = (ISet<double>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
