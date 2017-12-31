//
// Serializer for java.util.Map<java.lang.Integer,byps.test.api.inl.Point2D>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1358523233 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1358523233();
		
		public BSerializer_1358523233()
			: base(1358523233) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<int,byps.test.api.inl.Point2D> map = new Dictionary<int,byps.test.api.inl.Point2D>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				int key = bbuf.getInt();
				byps.test.api.inl.Point2D value = (byps.test.api.inl.Point2D)bin.readObj(false, byps.test.api.inl.BSerializer_1835035436.instance);
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<int,byps.test.api.inl.Point2D> map = (Dictionary<int,byps.test.api.inl.Point2D>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<int,byps.test.api.inl.Point2D> obj in map) {
				bbuf.putInt(obj.Key);
				bout.writeObj(obj.Value, false, byps.test.api.inl.BSerializer_1835035436.instance);
			}
		}
		
	}
} // namespace
