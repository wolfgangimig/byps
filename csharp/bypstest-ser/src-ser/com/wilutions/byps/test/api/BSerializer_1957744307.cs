//
// Serializer for int[][]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1957744307 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1957744307();
		
		public BSerializer_1957744307() : 
			base(1957744307) {}
		
		public override int size(Object obj, BBinaryModel bmodel) { 
			int elementSize = 4;
			int[,] arr = (int[,])obj;
			int n = arr.GetLength(0);
			n *= arr.GetLength(1);
			return bmodel.computeArrayWireSize(elementSize, n);
		}
		
		public override Object read(Object obj1, BInput bin1, long version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n1 = bbuf.getLength();
			int n0 = bbuf.getLength();
			
			// create array
			int[,] arr =  new int[n1,n0];
			
			// read
			for (int i1 = 0; i1 < n1; i1++) {
				for (int i0 = 0; i0 < n0; i0++) {
					arr[i1,i0] = bbuf.getInt();
				}
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			int[,] arr = (int[,])obj1;
			
			// lengths
			int n1 = arr.GetLength(0);
			int n0 = arr.GetLength(1);
			bbuf.putLength(n1);
			bbuf.putLength(n0);
			
			// write
			for (int i1 = 0; i1 < n1; i1++) {
				for (int i0 = 0; i0 < n0; i0++) {
					bbuf.putInt(arr[i1,i0]);
				}
			}
		}
		
	}
} // namespace
