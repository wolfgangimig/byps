//
// Serializer for boolean[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_2058423690 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2058423690();
		
		public BSerializer_2058423690() : 
			base(2058423690) {}
		
		public override int size(Object obj, BBinaryModel bmodel) { 
			int elementSize = 4;
			bool[] arr = (bool[])obj;
			int n = arr.GetLength(0);
			return bmodel.computeArrayWireSize(elementSize, n);
		}
		
		public override Object read(Object obj1, BInput bin1, int version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			bool[] arr =  new bool[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = bbuf.getBoolean();
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			bool[] arr = (bool[])obj1;
			
			// lengths
			int n0 = arr.GetLength(0);
			bbuf.putLength(n0);
			
			// write
			for (int i0 = 0; i0 < n0; i0++) {
				bbuf.putBoolean(arr[i0]);
			}
		}
		
	}
} // namespace
