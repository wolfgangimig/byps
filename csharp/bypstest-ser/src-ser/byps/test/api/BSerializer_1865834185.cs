//
// Serializer for java.util.List<java.util.List<int[][][][]>>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1865834185 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1865834185();
		
		public BSerializer_1865834185() 
			: base(1865834185) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<IList<int[,,,]>> arr = new List<IList<int[,,,]>>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				IList<int[,,,]> obj = (IList<int[,,,]>)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<IList<int[,,,]>> arr = (IList<IList<int[,,,]>>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (IList<int[,,,]> obj in arr) {
				bout.writeObj(obj, false, byps.test.api.BSerializer_1088217157.instance);
			}
		}
		
	}
} // namespace
