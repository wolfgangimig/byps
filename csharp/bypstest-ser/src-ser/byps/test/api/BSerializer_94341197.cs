//
// Serializer for java.util.Map<java.lang.Character,java.lang.Float>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_94341197 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_94341197();
		
		public BSerializer_94341197()
			: base(94341197) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<char,float> map = new Dictionary<char,float>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				char key = bbuf.getChar();
				float value = bbuf.getFloat();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<char,float> map = (Dictionary<char,float>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<char,float> obj in map) {
				bbuf.putChar(obj.Key);
				bbuf.putFloat(obj.Value);
			}
		}
		
	}
} // namespace
