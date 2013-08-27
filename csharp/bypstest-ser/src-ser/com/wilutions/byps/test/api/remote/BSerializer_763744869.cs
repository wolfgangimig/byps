//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setString1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_763744869 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_763744869();
		
		public BSerializer_763744869()
			: base(763744869) {}
		
		public BSerializer_763744869(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: string1 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setString1 obj = (BRequest_RemoteListTypes_setString1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._string1, false, com.wilutions.byps.test.api.BSerializer_2123584667.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setString1 obj = (BRequest_RemoteListTypes_setString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setString1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._string1 = (IList<String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
