//
// Serializer for java.util.Set<java.lang.Float>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1898022288 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_1898022288();
		
		public BSerializer_1898022288() 
			: base(1898022288) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<float> arr = new HashSet<float>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				float obj = bbuf.getFloat();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			ISet<float> arr = (ISet<float>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (float obj in arr) {
				bbuf.putFloat(obj);
			}
		}
		
	}
} // namespace
