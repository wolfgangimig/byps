//
// Serializer for java.util.List<java.lang.Character>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1661807911 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1661807911();
		
		public BSerializer_1661807911() 
			: base(1661807911) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<char> arr = new List<char>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				char obj = bbuf.getChar();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<char> arr = (IList<char>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (char obj in arr) {
				bbuf.putChar(obj);
			}
		}
		
	}
} // namespace
