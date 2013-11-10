//
// Serializer for java.util.Set<java.util.Date>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1097919350 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_1097919350();
		
		public BSerializer_1097919350() 
			: base(1097919350) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<java.util.Date> arr = new HashSet<java.util.Date>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				java.util.Date obj = bbuf.getDate();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			ISet<java.util.Date> arr = (ISet<java.util.Date>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (java.util.Date obj in arr) {
				bbuf.putDate(obj);
			}
		}
		
	}
} // namespace
