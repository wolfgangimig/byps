//
// Serializer for com.wilutions.byps.test.api.list.ListListTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.list
{
	
	public class BSerializer_3002 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_3002();
		
		public BSerializer_3002()
			: base(3002) {}
		
		public BSerializer_3002(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: int2 */ + 4			
			       /* pos=4: int3 */ + 4			
			       /* pos=8: int24 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			ListListTypes obj = (ListListTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj.Int2, false, com.wilutions.byps.test.api.BSerializer_1746702954.instance);
			bout.writeObj(obj.Int24, false, com.wilutions.byps.test.api.BSerializer_1865834185.instance);
			bout.writeObj(obj.Int3, false, com.wilutions.byps.test.api.BSerializer_1633500852.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			ListListTypes obj = (ListListTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new ListListTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Int2 = (IList<IList<int>>)bin.readObj(false, null);
			obj.Int24 = (IList<IList<int[,,,]>>)bin.readObj(false, null);
			obj.Int3 = (IList<IDictionary<int,IList<HashSet<int>>>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
