//
// Serializer for byps.test.api.inherit.Class1Collections
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
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
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.List1, false, byps.test.api.BSerializer_510524840.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Map1, false, byps.test.api.BSerializer_2058676657.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.Set1, false, byps.test.api.BSerializer_484881308.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Class1Collections obj = (Class1Collections)(obj1 != null ? obj1 : bin.onObjectCreated(new Class1Collections()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.List1 = (IList<byps.test.api.inherit.Class1>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Map1 = (IDictionary<String,byps.test.api.inherit.Class1>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Set1 = (ISet<byps.test.api.inherit.Class1>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
