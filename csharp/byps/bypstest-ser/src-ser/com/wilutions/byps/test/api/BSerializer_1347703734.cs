//
// Serializer for java.util.Map<java.lang.Integer,java.lang.Integer>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1347703734 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1347703734();
		
		public BSerializer_1347703734()
			: base(1347703734) {}		
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<int,int> map = new Dictionary<int,int>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				int key = bbuf.getInt();
				int value = bbuf.getInt();
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<int,int> map = (Dictionary<int,int>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<int,int> obj in map) {
				bbuf.putInt(obj.Key);
				bbuf.putInt(obj.Value);
			}
		}
		
	}
} // namespace
