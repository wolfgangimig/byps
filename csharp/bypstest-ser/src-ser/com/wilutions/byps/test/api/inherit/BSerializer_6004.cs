//
// Serializer for com.wilutions.byps.test.api.inherit.Class1Collections
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_6004 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_6004();
		
		public BSerializer_6004()
			: base(6004) {}
		
		public BSerializer_6004(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Class1Collections obj = (Class1Collections)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj.List1, false, com.wilutions.byps.test.api.BSerializer_317887457.instance);
			bout.writeObj(obj.Map1, false, com.wilutions.byps.test.api.BSerializer_981592984.instance);
			bout.writeObj(obj.Set1, false, com.wilutions.byps.test.api.BSerializer_2114305573.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Class1Collections obj = (Class1Collections)(obj1 != null ? obj1 : bin.onObjectCreated(new Class1Collections()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.List1 = (IList<com.wilutions.byps.test.api.inherit.Class1>)bin.readObj(false, null);
			obj.Map1 = (IDictionary<String,com.wilutions.byps.test.api.inherit.Class1>)bin.readObj(false, null);
			obj.Set1 = (ISet<com.wilutions.byps.test.api.inherit.Class1>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
