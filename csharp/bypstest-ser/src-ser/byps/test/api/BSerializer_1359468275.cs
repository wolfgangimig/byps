//
// Serializer for double[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1359468275 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1359468275();
		
		public BSerializer_1359468275() : 
			base(1359468275) {}
		
		public override Object read(Object obj1, BInput bin1, long version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			double[] arr =  new double[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = bbuf.getDouble();
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			double[] arr = (double[])obj1;
			
			// lengths
			int n0 = arr.GetLength(0);
			bbuf.putLength(n0);
			
			// write
			for (int i0 = 0; i0 < n0; i0++) {
				bbuf.putDouble(arr[i0]);
			}
		}
		
	}
} // namespace
