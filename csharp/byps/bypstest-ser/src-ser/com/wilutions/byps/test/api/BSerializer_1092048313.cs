//
// Serializer for com.wilutions.byps.test.api.enu.EnumPlanets[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1092048313 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1092048313();
		
		public BSerializer_1092048313() : 
			base(1092048313) {}
		
		public override int size(Object obj, BBinaryModel bmodel) { 
			int elementSize = 4;
			com.wilutions.byps.test.api.enu.EnumPlanets[] arr = (com.wilutions.byps.test.api.enu.EnumPlanets[])obj;
			int n = arr.GetLength(0);
			return bmodel.computeArrayWireSize(elementSize, n);
		}
		
		public override Object read(Object obj1, BInput bin1, int version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			com.wilutions.byps.test.api.enu.EnumPlanets[] arr =  new com.wilutions.byps.test.api.enu.EnumPlanets[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = (com.wilutions.byps.test.api.enu.EnumPlanets)bbuf.getInt();
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			com.wilutions.byps.test.api.enu.EnumPlanets[] arr = (com.wilutions.byps.test.api.enu.EnumPlanets[])obj1;
			
			// lengths
			int n0 = arr.GetLength(0);
			bbuf.putLength(n0);
			
			// write
			for (int i0 = 0; i0 < n0; i0++) {
				bbuf.putInt((int)((com.wilutions.byps.test.api.enu.EnumPlanets)arr[i0]));
			}
		}
		
	}
} // namespace
