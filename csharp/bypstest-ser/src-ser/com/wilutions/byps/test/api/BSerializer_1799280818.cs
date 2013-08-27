//
// Serializer for java.util.Map<java.lang.Integer,byte[]>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1799280818 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1799280818();
		
		public BSerializer_1799280818()
			: base(1799280818) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<int,byte[]> map = new Dictionary<int,byte[]>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				int key = bbuf.getInt();
				byte[] value = (byte[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<int,byte[]> map = (Dictionary<int,byte[]>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<int,byte[]> obj in map) {
				bbuf.putInt(obj.Key);
				bout.writeObj(obj.Value, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
			}
		}
		
	}
} // namespace
