//
// Serializer for java.util.Map<java.lang.String,java.util.Date>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1366799209 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1366799209();
		
		public BSerializer_1366799209()
			: base(1366799209) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<String,DateTime> map = new Dictionary<String,DateTime>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				String key = bbuf.getString();
				DateTime value = bbuf.getDate();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<String,DateTime> map = (Dictionary<String,DateTime>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<String,DateTime> obj in map) {
				bbuf.putString(obj.Key);
				bbuf.putDate(obj.Value);
			}
		}
		
	}
} // namespace
