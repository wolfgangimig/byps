//
// Serializer for java.lang.Object[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_183594037 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_183594037();
		
		public BSerializer_183594037() : 
			base(183594037) {}
		
		public override int size(Object obj, BBinaryModel bmodel) { 
			int elementSize = bmodel.pointerSize;
			Object[] arr = (Object[])obj;
			int n = arr.GetLength(0);
			return bmodel.computeArrayWireSize(elementSize, n);
		}
		
		public override Object read(Object obj1, BInput bin1, int version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			Object[] arr =  new Object[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = (Object)bin.readObj(false, null);
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			Object[] arr = (Object[])obj1;
			
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
