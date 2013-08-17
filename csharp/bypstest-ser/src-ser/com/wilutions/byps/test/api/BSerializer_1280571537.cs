//
// Serializer for java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1280571537 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_1280571537();
		
		public BSerializer_1280571537() 
			: base(1280571537) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<com.wilutions.byps.test.api.prim.PrimitiveTypes> arr = new HashSet<com.wilutions.byps.test.api.prim.PrimitiveTypes>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				com.wilutions.byps.test.api.prim.PrimitiveTypes obj = (com.wilutions.byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> arr = (ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (com.wilutions.byps.test.api.prim.PrimitiveTypes obj in arr) {
				bout.writeObj(obj, false, null);
			}
		}
		
	}
} // namespace
