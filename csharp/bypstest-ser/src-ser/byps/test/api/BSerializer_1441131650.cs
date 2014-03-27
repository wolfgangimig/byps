//
// Serializer for byps.test.api.enu.EnumPlanets[]
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1441131650 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1441131650();
		
		public BSerializer_1441131650() : 
			base(1441131650) {}
		
		public override Object read(Object obj1, BInput bin1, long version) {
			BInputBin bin = (BInputBin)bin1;
			BBufferBin bbuf = bin.bbuf;
			
			// lengths
			int n0 = bbuf.getLength();
			
			// create array
			byps.test.api.enu.EnumPlanets[] arr =  new byps.test.api.enu.EnumPlanets[n0];
			
			// read
			for (int i0 = 0; i0 < n0; i0++) {
				arr[i0] = (byps.test.api.enu.EnumPlanets)bbuf.getInt();
			}
			
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version) {
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			
			byps.test.api.enu.EnumPlanets[] arr = (byps.test.api.enu.EnumPlanets[])obj1;
			
			// lengths
			int n0 = arr.GetLength(0);
			bbuf.putLength(n0);
			
			// write
			for (int i0 = 0; i0 < n0; i0++) {
				bbuf.putInt((int)((byps.test.api.enu.EnumPlanets)arr[i0]));
			}
		}
		
	}
} // namespace
