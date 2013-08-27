﻿//
// Serializer for com.wilutions.byps.test.api.cons.AllTypesZ[][]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1981543076 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1981543076();
		
		public BSerializer_1981543076() : 
			base(1981543076) {}
		
		public override int size(Object obj, BBinaryModel bmodel) { 
			int elementSize = bmodel.pointerSize;
			com.wilutions.byps.test.api.cons.AllTypesZ[,] arr = (com.wilutions.byps.test.api.cons.AllTypesZ[,])obj;
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
			com.wilutions.byps.test.api.cons.AllTypesZ[,] arr =  new com.wilutions.byps.test.api.cons.AllTypesZ[n1,n0];
			
			// read
			for (int i1 = 0; i1 < n1; i1++) {
				for (int i0 = 0; i0 < n0; i0++) {
					arr[i1,i0] = (com.wilutions.byps.test.api.cons.AllTypesZ)bin.readObj(false, null);
				}
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			com.wilutions.byps.test.api.cons.AllTypesZ[,] arr = (com.wilutions.byps.test.api.cons.AllTypesZ[,])obj1;
			
			// lengths
			int n1 = arr.GetLength(0);
			int n0 = arr.GetLength(1);
			bbuf.putLength(n1);
			bbuf.putLength(n0);
			
			// write
			for (int i1 = 0; i1 < n1; i1++) {
				for (int i0 = 0; i0 < n0; i0++) {
					bout.writeObj(arr[i1,i0], false, null);
				}
			}
		}
		
	}
} // namespace
