//
// Serializer for java.util.ArrayList<byps.test.api.enu.EnumPlanets>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_819140569 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_819140569();
		
		public BSerializer_819140569() 
			: base(819140569) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<byps.test.api.enu.EnumPlanets> arr = new List<byps.test.api.enu.EnumPlanets>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				byps.test.api.enu.EnumPlanets obj = (byps.test.api.enu.EnumPlanets)bbuf.getInt();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			List<byps.test.api.enu.EnumPlanets> arr = (List<byps.test.api.enu.EnumPlanets>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (byps.test.api.enu.EnumPlanets obj in arr) {
				bbuf.putInt((int)((byps.test.api.enu.EnumPlanets)obj));
			}
		}
		
	}
} // namespace
