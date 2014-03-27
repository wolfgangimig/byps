//
// Serializer for java.util.Map<java.lang.Integer,java.util.List<java.lang.String>>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_132175071 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_132175071();
		
		public BSerializer_132175071()
			: base(132175071) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<int,IList<String>> map = new Dictionary<int,IList<String>>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				int key = bbuf.getInt();
				IList<String> value = (IList<String>)bin.readObj(false, null);
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<int,IList<String>> map = (Dictionary<int,IList<String>>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<int,IList<String>> obj in map) {
				bbuf.putInt(obj.Key);
				bout.writeObj(obj.Value, false, byps.test.api.BSerializer_2123584667.instance);
			}
		}
		
	}
} // namespace
