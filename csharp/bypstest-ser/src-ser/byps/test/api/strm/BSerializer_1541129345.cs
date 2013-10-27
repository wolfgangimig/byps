﻿//
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
			bbuf.putString(obj.ContentType);
			bout.writeObj(obj.ArrStream, false, byps.test.api.BSerializer_1950626768.instance);
			bout.writeObj(obj.Is1, false, null);
			bout.writeObj(obj.ListStream, false, byps.test.api.BSerializer_1218831438.instance);
			bout.writeObj(obj.MapStream, false, byps.test.api.BSerializer_779528402.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Stream1 obj = (Stream1)(obj1 != null ? obj1 : bin.onObjectCreated(new Stream1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.ContentType = bbuf.getString();
			obj.ArrStream = (System.IO.Stream[])bin.readObj(false, byps.test.api.BSerializer_1950626768.instance);
			obj.Is1 = (System.IO.Stream)bin.readObj(false, null);
			obj.ListStream = (IList<System.IO.Stream>)bin.readObj(false, null);
			obj.MapStream = (IDictionary<int,System.IO.Stream>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace