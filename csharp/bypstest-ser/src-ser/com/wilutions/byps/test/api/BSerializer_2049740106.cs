//
// Serializer for com.wilutions.byps.test.api.inl.Point2D[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_2049740106 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2049740106();
		
		public BSerializer_2049740106() : 
			base(2049740106) {}
		
		public override int size(Object obj, BBinaryModel bmodel) { 
			int elementSize = bmodel.pointerSize;
			com.wilutions.byps.test.api.inl.Point2D[] arr = (com.wilutions.byps.test.api.inl.Point2D[])obj;
			int n = arr.GetLength(0);
			return bmodel.computeArrayWireSize(elementSize, n);
		}
		
		public override Object read(Object obj1, BInput bin1, long version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			com.wilutions.byps.test.api.inl.Point2D[] arr =  new com.wilutions.byps.test.api.inl.Point2D[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = (com.wilutions.byps.test.api.inl.Point2D)bin.readObj(false, com.wilutions.byps.test.api.inl.BSerializer_1835035436.instance);
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			com.wilutions.byps.test.api.inl.Point2D[] arr = (com.wilutions.byps.test.api.inl.Point2D[])obj1;
			
			// lengths
			int n0 = arr.GetLength(0);
			bbuf.putLength(n0);
			
			// write
			for (int i0 = 0; i0 < n0; i0++) {
				bout.writeObj(arr[i0], false, com.wilutions.byps.test.api.inl.BSerializer_1835035436.instance);
			}
		}
		
	}
} // namespace
