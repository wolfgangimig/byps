//
// Serializer for java.util.List<byps.test.api.prim.PrimitiveTypes>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1596367810 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1596367810();
		
		public BSerializer_1596367810() 
			: base(1596367810) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<byps.test.api.prim.PrimitiveTypes> arr = new List<byps.test.api.prim.PrimitiveTypes>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				byps.test.api.prim.PrimitiveTypes obj = (byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<byps.test.api.prim.PrimitiveTypes> arr = (IList<byps.test.api.prim.PrimitiveTypes>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (byps.test.api.prim.PrimitiveTypes obj in arr) {
				bout.writeObj(obj, false, null);
			}
		}
		
	}
} // namespace
