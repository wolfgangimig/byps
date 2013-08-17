//
// Serializer for java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_49984088 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_49984088();
		
		public BSerializer_49984088()
			: base(49984088) {}		
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<int,IList<HashSet<int>>> map = new Dictionary<int,IList<HashSet<int>>>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				int key = bbuf.getInt();
				IList<HashSet<int>> value = (IList<HashSet<int>>)bin.readObj(false, null);
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<int,IList<HashSet<int>>> map = (Dictionary<int,IList<HashSet<int>>>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<int,IList<HashSet<int>>> obj in map) {
				bbuf.putInt(obj.Key);
				bout.writeObj(obj.Value, false, com.wilutions.byps.test.api.BSerializer_724129228.instance);
			}
		}
		
	}
} // namespace
