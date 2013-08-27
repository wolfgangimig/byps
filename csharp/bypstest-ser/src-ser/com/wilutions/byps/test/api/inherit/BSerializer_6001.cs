﻿//
// Serializer for com.wilutions.byps.test.api.inherit.Class1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_6001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_6001();
		
		public BSerializer_6001()
			: base(6001) {}
		
		public BSerializer_6001(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: int1 */ + 4			
			       /* pos=4: nextClass1 */ + 4			
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Class1 obj = (Class1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj.Int1);
			bout.writeObj(obj.NextClass1, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Class1 obj = (Class1)(obj1 != null ? obj1 : bin.onObjectCreated(new Class1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Int1 = bbuf.getInt();
			obj.NextClass1 = (com.wilutions.byps.test.api.inherit.Class1)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
