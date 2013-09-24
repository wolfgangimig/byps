//
// Serializer for com.wilutions.byps.test.api.cons.HebrewZ[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_2092671091 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2092671091();
		
		public BSerializer_2092671091() : 
			base(2092671091) {}
		
		public override Object read(Object obj1, BInput bin1, long version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			com.wilutions.byps.test.api.cons.HebrewZ[] arr =  new com.wilutions.byps.test.api.cons.HebrewZ[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = (com.wilutions.byps.test.api.cons.HebrewZ)bin.readObj(false, null);
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			com.wilutions.byps.test.api.cons.HebrewZ[] arr = (com.wilutions.byps.test.api.cons.HebrewZ[])obj1;
			
			// lengths
			int n0 = arr.GetLength(0);
			bbuf.putLength(n0);
			
			// write
			for (int i0 = 0; i0 < n0; i0++) {
				bout.writeObj(arr[i0], false, null);
			}
		}
		
	}
} // namespace
