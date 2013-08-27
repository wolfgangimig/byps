//
// Serializer for java.util.List<java.lang.Boolean>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1617670280 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1617670280();
		
		public BSerializer_1617670280() 
			: base(1617670280) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<bool> arr = new List<bool>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				bool obj = bbuf.getBoolean();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<bool> arr = (IList<bool>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (bool obj in arr) {
				bbuf.putBoolean(obj);
			}
		}
		
	}
} // namespace
