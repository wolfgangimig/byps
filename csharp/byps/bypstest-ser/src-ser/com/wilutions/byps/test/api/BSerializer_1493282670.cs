//
// Serializer for java.util.Set<java.lang.Integer>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1493282670 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_1493282670();
		
		public BSerializer_1493282670() 
			: base(1493282670) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<int> arr = new HashSet<int>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				int obj = bbuf.getInt();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			ISet<int> arr = (ISet<int>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (int obj in arr) {
				bbuf.putInt(obj);
			}
		}
		
	}
} // namespace
