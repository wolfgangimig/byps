//
// Serializer for java.util.Map<java.lang.Short,java.lang.Long>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1973996106 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1973996106();
		
		public BSerializer_1973996106()
			: base(1973996106) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<short,long> map = new Dictionary<short,long>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				short key = bbuf.getShort();
				long value = bbuf.getLong();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<short,long> map = (Dictionary<short,long>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<short,long> obj in map) {
				bbuf.putShort(obj.Key);
				bbuf.putLong(obj.Value);
			}
		}
		
	}
} // namespace
