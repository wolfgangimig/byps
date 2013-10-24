//
// Serializer for java.util.Map<java.lang.String,byps.test.api.enu.EnumPlanets>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_493795497 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_493795497();
		
		public BSerializer_493795497()
			: base(493795497) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<String,byps.test.api.enu.EnumPlanets> map = new Dictionary<String,byps.test.api.enu.EnumPlanets>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				String key = bbuf.getString();
				byps.test.api.enu.EnumPlanets value = (byps.test.api.enu.EnumPlanets)bbuf.getInt();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<String,byps.test.api.enu.EnumPlanets> map = (Dictionary<String,byps.test.api.enu.EnumPlanets>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<String,byps.test.api.enu.EnumPlanets> obj in map) {
				bbuf.putString(obj.Key);
				bbuf.putInt((int)((byps.test.api.enu.EnumPlanets)obj.Value));
			}
		}
		
	}
} // namespace
