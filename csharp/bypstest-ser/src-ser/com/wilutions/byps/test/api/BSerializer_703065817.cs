//
// Serializer for java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_703065817 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_703065817();
		
		public BSerializer_703065817()
			: base(703065817) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> map = new Dictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				int key = bbuf.getInt();
				com.wilutions.byps.test.api.prim.PrimitiveTypes value = (com.wilutions.byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> map = (Dictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> obj in map) {
				bbuf.putInt(obj.Key);
				bout.writeObj(obj.Value, false, null);
			}
		}
		
	}
} // namespace
