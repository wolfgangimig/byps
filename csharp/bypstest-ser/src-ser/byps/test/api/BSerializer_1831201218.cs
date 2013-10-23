//
// Serializer for java.util.Map<java.lang.Integer,byps.test.api.prim.PrimitiveTypes>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1831201218 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1831201218();
		
		public BSerializer_1831201218()
			: base(1831201218) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<int,byps.test.api.prim.PrimitiveTypes> map = new Dictionary<int,byps.test.api.prim.PrimitiveTypes>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				int key = bbuf.getInt();
				byps.test.api.prim.PrimitiveTypes value = (byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<int,byps.test.api.prim.PrimitiveTypes> map = (Dictionary<int,byps.test.api.prim.PrimitiveTypes>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<int,byps.test.api.prim.PrimitiveTypes> obj in map) {
				bbuf.putInt(obj.Key);
				bout.writeObj(obj.Value, false, null);
			}
		}
		
	}
} // namespace
