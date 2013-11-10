//
// Serializer for byps.test.api.strm.Stream1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.strm
{
	
	public class BSerializer_1541129345 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1541129345();
		
		public BSerializer_1541129345()
			: base(1541129345) {}
		
		public BSerializer_1541129345(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Stream1 obj = (Stream1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bbuf.putString(obj.ContentType);
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.ArrStream, false, byps.test.api.BSerializer_1950626768.instance);
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.Is1, false, null);
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.ListStream, false, byps.test.api.BSerializer_1218831438.instance);
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.MapStream, false, byps.test.api.BSerializer_779528402.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Stream1 obj = (Stream1)(obj1 != null ? obj1 : bin.onObjectCreated(new Stream1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.ContentType = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:445
			obj.ArrStream = (System.IO.Stream[])bin.readObj(false, byps.test.api.BSerializer_1950626768.instance);
			// checkpoint byps.gen.cs.PrintContext:445
			obj.Is1 = (System.IO.Stream)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:445
			obj.ListStream = (IList<System.IO.Stream>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:445
			obj.MapStream = (IDictionary<int,System.IO.Stream>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
