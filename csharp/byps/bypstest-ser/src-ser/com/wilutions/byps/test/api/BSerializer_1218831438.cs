//
// Serializer for java.util.List<java.io.InputStream>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1218831438 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1218831438();
		
		public BSerializer_1218831438() 
			: base(1218831438) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<System.IO.Stream> arr = new List<System.IO.Stream>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				System.IO.Stream obj = (System.IO.Stream)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<System.IO.Stream> arr = (IList<System.IO.Stream>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (System.IO.Stream obj in arr) {
				bout.writeObj(obj, false, null);
			}
		}
		
	}
} // namespace
