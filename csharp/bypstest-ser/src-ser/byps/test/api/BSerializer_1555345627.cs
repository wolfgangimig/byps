//
// Serializer for java.util.List<java.lang.Double>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1555345627 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1555345627();
		
		public BSerializer_1555345627() 
			: base(1555345627) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<double> arr = new List<double>(n);
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
			IList<double> arr = (IList<double>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (double obj in arr) {
				bbuf.putDouble(obj);
			}
		}
		
	}
} // namespace
