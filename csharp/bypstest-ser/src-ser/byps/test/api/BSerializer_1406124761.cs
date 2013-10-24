//
// Serializer for java.util.Set<int[]>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1406124761 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_1406124761();
		
		public BSerializer_1406124761() 
			: base(1406124761) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<int[]> arr = new HashSet<int[]>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				int[] obj = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			ISet<int[]> arr = (ISet<int[]>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (int[] obj in arr) {
				bout.writeObj(obj, false, byps.test.api.BSerializer_100361105.instance);
			}
		}
		
	}
} // namespace
