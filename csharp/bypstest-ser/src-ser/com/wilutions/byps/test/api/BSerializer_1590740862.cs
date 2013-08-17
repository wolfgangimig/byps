//
// Serializer for java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1590740862 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1590740862();
		
		public BSerializer_1590740862() 
			: base(1590740862) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<com.wilutions.byps.test.api.enu.EnumPlanets> arr = new List<com.wilutions.byps.test.api.enu.EnumPlanets>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				com.wilutions.byps.test.api.enu.EnumPlanets obj = (com.wilutions.byps.test.api.enu.EnumPlanets)bbuf.getInt();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			List<com.wilutions.byps.test.api.enu.EnumPlanets> arr = (List<com.wilutions.byps.test.api.enu.EnumPlanets>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (com.wilutions.byps.test.api.enu.EnumPlanets obj in arr) {
				bbuf.putInt((int)((com.wilutions.byps.test.api.enu.EnumPlanets)obj));
			}
		}
		
	}
} // namespace
