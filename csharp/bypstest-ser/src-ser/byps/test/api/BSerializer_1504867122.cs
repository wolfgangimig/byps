//
// Serializer for java.util.List<java.util.Date>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1504867122 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1504867122();
		
		public BSerializer_1504867122() 
			: base(1504867122) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<DateTime> arr = new List<DateTime>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				DateTime obj = bbuf.getDate();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<DateTime> arr = (IList<DateTime>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (DateTime obj in arr) {
				bbuf.putDate(obj);
			}
		}
		
	}
} // namespace
