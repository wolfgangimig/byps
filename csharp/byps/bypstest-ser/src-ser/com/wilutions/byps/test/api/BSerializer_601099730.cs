//
// Serializer for java.util.Map<java.lang.Long,java.lang.Short>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_601099730 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_601099730();
		
		public BSerializer_601099730()
			: base(601099730) {}		
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<long,short> map = new Dictionary<long,short>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				long key = bbuf.getLong();
				short value = bbuf.getShort();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<long,short> map = (Dictionary<long,short>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<long,short> obj in map) {
				bbuf.putLong(obj.Key);
				bbuf.putShort(obj.Value);
			}
		}
		
	}
} // namespace
