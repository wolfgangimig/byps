//
// Serializer for java.util.Map<java.lang.Byte,java.lang.Double>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1487265161 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1487265161();
		
		public BSerializer_1487265161()
			: base(1487265161) {}		
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<byte,double> map = new Dictionary<byte,double>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				byte key = bbuf.getByte();
				double value = bbuf.getDouble();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<byte,double> map = (Dictionary<byte,double>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<byte,double> obj in map) {
				bbuf.putByte(obj.Key);
				bbuf.putDouble(obj.Value);
			}
		}
		
	}
} // namespace
