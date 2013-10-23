//
// Serializer for byps.test.api.cons.HebrewZ[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_92445340 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_92445340();
		
		public BSerializer_92445340() : 
			base(92445340) {}
		
		public override Object read(Object obj1, BInput bin1, long version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			byps.test.api.cons.HebrewZ[] arr =  new byps.test.api.cons.HebrewZ[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = (byps.test.api.cons.HebrewZ)bin.readObj(false, null);
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			byps.test.api.cons.HebrewZ[] arr = (byps.test.api.cons.HebrewZ[])obj1;
			
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
