//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setBoolean1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1779393754 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1779393754();
		
		public BSerializer_1779393754()
			: base(1779393754) {}
		
		public BSerializer_1779393754(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: boolean1 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteSetTypes_setBoolean1 obj = (BRequest_RemoteSetTypes_setBoolean1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._boolean1, false, com.wilutions.byps.test.api.BSerializer_1365696060.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_setBoolean1 obj = (BRequest_RemoteSetTypes_setBoolean1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setBoolean1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._boolean1 = (ISet<bool>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
