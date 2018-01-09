//
// Serializer for long[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1097129250 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1097129250();
		
		public BSerializer_1097129250() : 
			base(1097129250) {}
		
		public override Object read(Object obj1, BInput bin1, long version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			long[] arr =  new long[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = bbuf.getLong();
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			long[] arr = (long[])obj1;
			
			// lengths
			int n0 = arr.GetLength(0);
			bbuf.putLength(n0);
			
			// write
			for (int i0 = 0; i0 < n0; i0++) {
				bbuf.putLong(arr[i0]);
			}
		}
		
	}
} // namespace
