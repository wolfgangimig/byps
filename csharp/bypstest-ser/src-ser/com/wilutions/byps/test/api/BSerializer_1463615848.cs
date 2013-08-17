//
// Serializer for java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1463615848 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1463615848();
		
		public BSerializer_1463615848() 
			: base(1463615848) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<IList<com.wilutions.byps.test.api.inl.Point2D>> arr = new List<IList<com.wilutions.byps.test.api.inl.Point2D>>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				IList<com.wilutions.byps.test.api.inl.Point2D> obj = (IList<com.wilutions.byps.test.api.inl.Point2D>)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<IList<com.wilutions.byps.test.api.inl.Point2D>> arr = (IList<IList<com.wilutions.byps.test.api.inl.Point2D>>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (IList<com.wilutions.byps.test.api.inl.Point2D> obj in arr) {
				bout.writeObj(obj, false, com.wilutions.byps.test.api.BSerializer_172221196.instance);
			}
		}
		
	}
} // namespace
