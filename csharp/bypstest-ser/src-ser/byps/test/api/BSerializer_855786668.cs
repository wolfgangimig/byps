//
// Serializer for java.util.TreeSet<java.lang.Integer>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_855786668 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_855786668();
		
		public BSerializer_855786668() 
			: base(855786668) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<int> arr = new HashSet<int>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				int obj = bbuf.getInt();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			HashSet<int> arr = (HashSet<int>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (int obj in arr) {
				bbuf.putInt(obj);
			}
		}
		
	}
} // namespace
