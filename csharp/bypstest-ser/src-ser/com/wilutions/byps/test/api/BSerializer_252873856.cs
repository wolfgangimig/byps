//
// Serializer for java.util.Map<java.lang.String,com.wilutions.byps.test.api.enu.EnumPlanets>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_252873856 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_252873856();
		
		public BSerializer_252873856()
			: base(252873856) {}		
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<String,com.wilutions.byps.test.api.enu.EnumPlanets> map = new Dictionary<String,com.wilutions.byps.test.api.enu.EnumPlanets>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				String key = bbuf.getString();
				com.wilutions.byps.test.api.enu.EnumPlanets value = (com.wilutions.byps.test.api.enu.EnumPlanets)bbuf.getInt();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<String,com.wilutions.byps.test.api.enu.EnumPlanets> map = (Dictionary<String,com.wilutions.byps.test.api.enu.EnumPlanets>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<String,com.wilutions.byps.test.api.enu.EnumPlanets> obj in map) {
				bbuf.putString(obj.Key);
				bbuf.putInt((int)((com.wilutions.byps.test.api.enu.EnumPlanets)obj.Value));
			}
		}
		
	}
} // namespace
