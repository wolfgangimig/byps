//
// Serializer for com.wilutions.byps.test.api.prim.PrimitiveTypes[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_801243127 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_801243127();
		
		public BSerializer_801243127() : 
			base(801243127) {}
		
		public override int size(Object obj, BBinaryModel bmodel) { 
			int elementSize = bmodel.pointerSize;
			com.wilutions.byps.test.api.prim.PrimitiveTypes[] arr = (com.wilutions.byps.test.api.prim.PrimitiveTypes[])obj;
			int n = arr.GetLength(0);
			return bmodel.computeArrayWireSize(elementSize, n);
		}
		
		public override Object read(Object obj1, BInput bin1, int version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			com.wilutions.byps.test.api.prim.PrimitiveTypes[] arr =  new com.wilutions.byps.test.api.prim.PrimitiveTypes[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = (com.wilutions.byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			com.wilutions.byps.test.api.prim.PrimitiveTypes[] arr = (com.wilutions.byps.test.api.prim.PrimitiveTypes[])obj1;
			
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
