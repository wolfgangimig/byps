//
// Serializer for java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1633500852 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1633500852();
		
		public BSerializer_1633500852() 
			: base(1633500852) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<IDictionary<int,IList<HashSet<int>>>> arr = new List<IDictionary<int,IList<HashSet<int>>>>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				IDictionary<int,IList<HashSet<int>>> obj = (IDictionary<int,IList<HashSet<int>>>)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<IDictionary<int,IList<HashSet<int>>>> arr = (IList<IDictionary<int,IList<HashSet<int>>>>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (IDictionary<int,IList<HashSet<int>>> obj in arr) {
				bout.writeObj(obj, false, com.wilutions.byps.test.api.BSerializer_49984088.instance);
			}
		}
		
	}
} // namespace
