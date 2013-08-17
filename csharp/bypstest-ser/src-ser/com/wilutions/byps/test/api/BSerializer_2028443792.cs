//
// Serializer for java.util.Set<java.lang.Short>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_2028443792 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_2028443792();
		
		public BSerializer_2028443792() 
			: base(2028443792) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<short> arr = new HashSet<short>();
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
			ISet<short> arr = (ISet<short>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (short obj in arr) {
				bbuf.putShort(obj);
			}
		}
		
	}
} // namespace
