//
// Serializer for java.util.List<java.lang.Float>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1628501332 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1628501332();
		
		public BSerializer_1628501332() 
			: base(1628501332) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<float> arr = new List<float>(n);
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
			IList<float> arr = (IList<float>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (float obj in arr) {
				bbuf.putFloat(obj);
			}
		}
		
	}
} // namespace
