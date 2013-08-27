//
// Serializer for java.util.List<java.lang.Long>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1050216688 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1050216688();
		
		public BSerializer_1050216688() 
			: base(1050216688) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<long> arr = new List<long>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				long obj = bbuf.getLong();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<long> arr = (IList<long>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (long obj in arr) {
				bbuf.putLong(obj);
			}
		}
		
	}
} // namespace
