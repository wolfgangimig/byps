//
// Serializer for java.util.Set<java.lang.Double>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1320560671 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_1320560671();
		
		public BSerializer_1320560671() 
			: base(1320560671) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<double> arr = new HashSet<double>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				double obj = bbuf.getDouble();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			ISet<double> arr = (ISet<double>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (double obj in arr) {
				bbuf.putDouble(obj);
			}
		}
		
	}
} // namespace
