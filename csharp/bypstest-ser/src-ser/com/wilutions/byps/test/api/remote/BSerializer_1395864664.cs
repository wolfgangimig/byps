﻿//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setShort1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1395864664 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1395864664();
		
		public BSerializer_1395864664()
			: base(1395864664) {}
		
		public BSerializer_1395864664(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: short1 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setShort1 obj = (BRequest_RemoteMapTypes_setShort1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._short1, false, com.wilutions.byps.test.api.BSerializer_601099730.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setShort1 obj = (BRequest_RemoteMapTypes_setShort1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setShort1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._short1 = (IDictionary<long,short>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
