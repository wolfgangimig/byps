//
// Serializer for java.util.TreeMap<java.lang.Float,java.lang.Character>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_8789515 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_8789515();
		
		public BSerializer_8789515()
			: base(8789515) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<float,char> map = new Dictionary<float,char>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				float key = bbuf.getFloat();
				char value = bbuf.getChar();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<float,char> map = (Dictionary<float,char>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<float,char> obj in map) {
				bbuf.putFloat(obj.Key);
				bbuf.putChar(obj.Value);
			}
		}
		
	}
} // namespace
