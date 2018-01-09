//
// Serializer for java.util.Set<byps.test.api.prim.PrimitiveTypes>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_673917574 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_673917574();
		
		public BSerializer_673917574() 
			: base(673917574) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<byps.test.api.prim.PrimitiveTypes> arr = new HashSet<byps.test.api.prim.PrimitiveTypes>();
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
			ISet<byps.test.api.prim.PrimitiveTypes> arr = (ISet<byps.test.api.prim.PrimitiveTypes>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (byps.test.api.prim.PrimitiveTypes obj in arr) {
				bout.writeObj(obj, false, null);
			}
		}
		
	}
} // namespace
