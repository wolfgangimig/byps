//
// Serializer for java.util.List<com.wilutions.byps.test.api.inherit.Class1>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_317887457 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_317887457();
		
		public BSerializer_317887457() 
			: base(317887457) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<com.wilutions.byps.test.api.inherit.Class1> arr = new List<com.wilutions.byps.test.api.inherit.Class1>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				com.wilutions.byps.test.api.inherit.Class1 obj = (com.wilutions.byps.test.api.inherit.Class1)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<com.wilutions.byps.test.api.inherit.Class1> arr = (IList<com.wilutions.byps.test.api.inherit.Class1>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (com.wilutions.byps.test.api.inherit.Class1 obj in arr) {
				bout.writeObj(obj, false, null);
			}
		}
		
	}
} // namespace
