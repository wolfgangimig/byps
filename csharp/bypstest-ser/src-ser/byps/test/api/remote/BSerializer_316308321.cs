//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_setFloat1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_316308321 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_316308321();
		
		public BSerializer_316308321()
			: base(316308321) {}
		
		public BSerializer_316308321(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setFloat1 obj = (BRequest_RemoteMapTypes_setFloat1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.float1Value, false, byps.test.api.BSerializer_94341197.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setFloat1 obj = (BRequest_RemoteMapTypes_setFloat1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setFloat1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.float1Value = (IDictionary<char,float>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
