//
// Serializer for java.util.Map<java.lang.Integer,int[]>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1633750383 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1633750383();
		
		public BSerializer_1633750383()
			: base(1633750383) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<int,int[]> map = new Dictionary<int,int[]>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				int key = bbuf.getInt();
				int[] value = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<int,int[]> map = (Dictionary<int,int[]>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<int,int[]> obj in map) {
				bbuf.putInt(obj.Key);
				bout.writeObj(obj.Value, false, byps.test.api.BSerializer_100361105.instance);
			}
		}
		
	}
} // namespace
