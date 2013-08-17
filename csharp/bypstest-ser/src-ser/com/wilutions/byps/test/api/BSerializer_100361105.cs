//
// Serializer for int[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_100361105 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_100361105();
		
		public BSerializer_100361105() : 
			base(100361105) {}
		
		public override int size(Object obj, BBinaryModel bmodel) { 
			int elementSize = 4;
			int[] arr = (int[])obj;
			int n = arr.GetLength(0);
			return bmodel.computeArrayWireSize(elementSize, n);
		}
		
		public override Object read(Object obj1, BInput bin1, int version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			int[] arr =  new int[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = bbuf.getInt();
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			int[] arr = (int[])obj1;
			
			// lengths
			int n0 = arr.GetLength(0);
			bbuf.putLength(n0);
			
			// write
			for (int i0 = 0; i0 < n0; i0++) {
				bbuf.putInt(arr[i0]);
			}
		}
		
	}
} // namespace
