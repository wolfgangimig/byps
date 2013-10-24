//
// Serializer for java.util.HashMap<java.lang.Double,java.lang.Byte>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1972793385 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1972793385();
		
		public BSerializer_1972793385()
			: base(1972793385) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<double,byte> map = new Dictionary<double,byte>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				double key = bbuf.getDouble();
				byte value = bbuf.getByte();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<double,byte> map = (Dictionary<double,byte>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<double,byte> obj in map) {
				bbuf.putDouble(obj.Key);
				bbuf.putByte(obj.Value);
			}
		}
		
	}
} // namespace
