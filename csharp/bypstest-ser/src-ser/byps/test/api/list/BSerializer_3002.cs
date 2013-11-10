//
// Serializer for byps.test.api.list.ListListTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.list
{
	
	public class BSerializer_3002 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_3002();
		
		public BSerializer_3002()
			: base(3002) {}
		
		public BSerializer_3002(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			ListListTypes obj = (ListListTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.Int2, false, byps.test.api.BSerializer_1746702954.instance);
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.Int24, false, byps.test.api.BSerializer_1865834185.instance);
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.Int3, false, byps.test.api.BSerializer_1633500852.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			ListListTypes obj = (ListListTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new ListListTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.Int2 = (IList<IList<int>>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:445
			obj.Int24 = (IList<IList<int[,,,]>>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:445
			obj.Int3 = (IList<IDictionary<int,IList<HashSet<int>>>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
