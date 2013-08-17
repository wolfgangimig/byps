//
// Serializer for java.util.List<java.lang.Short>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1997002548 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1997002548();
		
		public BSerializer_1997002548() 
			: base(1997002548) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<short> arr = new List<short>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				short obj = bbuf.getShort();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<short> arr = (IList<short>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (short obj in arr) {
				bbuf.putShort(obj);
			}
		}
		
	}
} // namespace
