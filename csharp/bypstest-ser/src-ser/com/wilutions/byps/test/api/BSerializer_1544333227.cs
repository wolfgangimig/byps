//
// Serializer for java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1544333227 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1544333227();
		
		public BSerializer_1544333227() 
			: base(1544333227) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<com.wilutions.byps.test.api.prim.PrimitiveTypes> arr = new List<com.wilutions.byps.test.api.prim.PrimitiveTypes>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				com.wilutions.byps.test.api.prim.PrimitiveTypes obj = (com.wilutions.byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> arr = (IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (com.wilutions.byps.test.api.prim.PrimitiveTypes obj in arr) {
				bout.writeObj(obj, false, null);
			}
		}
		
	}
} // namespace
