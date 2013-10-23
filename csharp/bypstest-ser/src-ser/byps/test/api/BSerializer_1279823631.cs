//
// Serializer for java.util.Map<java.lang.String,java.lang.Boolean>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1279823631 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1279823631();
		
		public BSerializer_1279823631()
			: base(1279823631) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<String,bool> map = new Dictionary<String,bool>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				String key = bbuf.getString();
				bool value = bbuf.getBoolean();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<String,bool> map = (Dictionary<String,bool>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<String,bool> obj in map) {
				bbuf.putString(obj.Key);
				bbuf.putBoolean(obj.Value);
			}
		}
		
	}
} // namespace
