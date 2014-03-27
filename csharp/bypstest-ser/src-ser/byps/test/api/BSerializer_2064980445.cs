//
// Serializer for java.util.List<byps.test.api.inl.Point2D>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_2064980445 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_2064980445();
		
		public BSerializer_2064980445() 
			: base(2064980445) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<byps.test.api.inl.Point2D> arr = new List<byps.test.api.inl.Point2D>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				byps.test.api.inl.Point2D obj = (byps.test.api.inl.Point2D)bin.readObj(false, byps.test.api.inl.BSerializer_1835035436.instance);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<byps.test.api.inl.Point2D> arr = (IList<byps.test.api.inl.Point2D>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (byps.test.api.inl.Point2D obj in arr) {
				bout.writeObj(obj, false, byps.test.api.inl.BSerializer_1835035436.instance);
			}
		}
		
	}
} // namespace
