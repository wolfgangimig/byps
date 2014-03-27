//
// Serializer for java.util.List<java.util.List<byps.test.api.inl.Point2D>>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1823330785 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1823330785();
		
		public BSerializer_1823330785() 
			: base(1823330785) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<IList<byps.test.api.inl.Point2D>> arr = new List<IList<byps.test.api.inl.Point2D>>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				IList<byps.test.api.inl.Point2D> obj = (IList<byps.test.api.inl.Point2D>)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<IList<byps.test.api.inl.Point2D>> arr = (IList<IList<byps.test.api.inl.Point2D>>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (IList<byps.test.api.inl.Point2D> obj in arr) {
				bout.writeObj(obj, false, byps.test.api.BSerializer_2064980445.instance);
			}
		}
		
	}
} // namespace
