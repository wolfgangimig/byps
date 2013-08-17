//
// Serializer for java.util.List<java.lang.String>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_2123584667 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_2123584667();
		
		public BSerializer_2123584667() 
			: base(2123584667) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<String> arr = new List<String>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				String obj = bbuf.getString();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<String> arr = (IList<String>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (String obj in arr) {
				bbuf.putString(obj);
			}
		}
		
	}
} // namespace
