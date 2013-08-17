//
// Serializer for char[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1361632968 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1361632968();
		
		public BSerializer_1361632968() : 
			base(1361632968) {}
		
		public override int size(Object obj, BBinaryModel bmodel) { 
			int elementSize = 2;
			char[] arr = (char[])obj;
			int n = arr.GetLength(0);
			return bmodel.computeArrayWireSize(elementSize, n);
		}
		
		public override Object read(Object obj1, BInput bin1, int version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			char[] arr =  new char[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = bbuf.getChar();
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			char[] arr = (char[])obj1;
			
			// lengths
			int n0 = arr.GetLength(0);
			bbuf.putLength(n0);
			
			// write
			for (int i0 = 0; i0 < n0; i0++) {
				bbuf.putChar(arr[i0]);
			}
		}
		
	}
} // namespace
