//
// Serializer for java.util.Map<java.lang.String,java.lang.String>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1710660846 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1710660846();
		
		public BSerializer_1710660846()
			: base(1710660846) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<String,String> map = new Dictionary<String,String>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				String key = bbuf.getString();
				String value = bbuf.getString();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<String,String> map = (Dictionary<String,String>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<String,String> obj in map) {
				bbuf.putString(obj.Key);
				bbuf.putString(obj.Value);
			}
		}
		
	}
} // namespace
