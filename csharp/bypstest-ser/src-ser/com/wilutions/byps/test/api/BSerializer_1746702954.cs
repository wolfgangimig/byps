//
// Serializer for java.util.List<java.util.List<java.lang.Integer>>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1746702954 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1746702954();
		
		public BSerializer_1746702954() 
			: base(1746702954) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<IList<int>> arr = new List<IList<int>>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				IList<int> obj = (IList<int>)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<IList<int>> arr = (IList<IList<int>>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (IList<int> obj in arr) {
				bout.writeObj(obj, false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
			}
		}
		
	}
} // namespace
