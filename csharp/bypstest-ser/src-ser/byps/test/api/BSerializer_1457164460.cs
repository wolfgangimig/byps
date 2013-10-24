//
// Serializer for java.util.Set<java.lang.Long>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1457164460 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_1457164460();
		
		public BSerializer_1457164460() 
			: base(1457164460) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<long> arr = new HashSet<long>();
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
			ISet<long> arr = (ISet<long>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (long obj in arr) {
				bbuf.putLong(obj);
			}
		}
		
	}
} // namespace
