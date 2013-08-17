//
// Serializer for java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1851881336 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1851881336();
		
		public BSerializer_1851881336()
			: base(1851881336) {}		
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<int,com.wilutions.byps.test.api.inl.Point2D> map = new Dictionary<int,com.wilutions.byps.test.api.inl.Point2D>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				int key = bbuf.getInt();
				com.wilutions.byps.test.api.inl.Point2D value = (com.wilutions.byps.test.api.inl.Point2D)bin.readObj(false, com.wilutions.byps.test.api.inl.BSerializer_1835035436.instance);
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<int,com.wilutions.byps.test.api.inl.Point2D> map = (Dictionary<int,com.wilutions.byps.test.api.inl.Point2D>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<int,com.wilutions.byps.test.api.inl.Point2D> obj in map) {
				bbuf.putInt(obj.Key);
				bout.writeObj(obj.Value, false, com.wilutions.byps.test.api.inl.BSerializer_1835035436.instance);
			}
		}
		
	}
} // namespace
