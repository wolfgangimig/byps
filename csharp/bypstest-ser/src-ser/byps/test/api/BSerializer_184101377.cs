//
// Serializer for byps.test.api.inl.Point2D[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_184101377 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_184101377();
		
		public BSerializer_184101377() : 
			base(184101377) {}
		
		public override Object read(Object obj1, BInput bin1, long version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			byps.test.api.inl.Point2D[] arr =  new byps.test.api.inl.Point2D[n0];
			bin.onObjectCreated(arr);
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = (byps.test.api.inl.Point2D)bin.readObj(false, byps.test.api.inl.BSerializer_1835035436.instance);
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			byps.test.api.inl.Point2D[] arr = (byps.test.api.inl.Point2D[])obj1;
			
			// lengths
			int n0 = arr.GetLength(0);
			bbuf.putLength(n0);
			
			// write
			for (int i0 = 0; i0 < n0; i0++) {
				bout.writeObj(arr[i0], false, byps.test.api.inl.BSerializer_1835035436.instance);
			}
		}
		
	}
} // namespace
