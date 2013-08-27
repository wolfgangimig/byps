//
// Serializer for java.util.List<com.wilutions.byps.test.api.inl.Point2D>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_172221196 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_172221196();
		
		public BSerializer_172221196() 
			: base(172221196) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<com.wilutions.byps.test.api.inl.Point2D> arr = new List<com.wilutions.byps.test.api.inl.Point2D>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				com.wilutions.byps.test.api.inl.Point2D obj = (com.wilutions.byps.test.api.inl.Point2D)bin.readObj(false, com.wilutions.byps.test.api.inl.BSerializer_1835035436.instance);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<com.wilutions.byps.test.api.inl.Point2D> arr = (IList<com.wilutions.byps.test.api.inl.Point2D>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (com.wilutions.byps.test.api.inl.Point2D obj in arr) {
				bout.writeObj(obj, false, com.wilutions.byps.test.api.inl.BSerializer_1835035436.instance);
			}
		}
		
	}
} // namespace
