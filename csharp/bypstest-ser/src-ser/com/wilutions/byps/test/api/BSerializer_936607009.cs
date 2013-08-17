//
// Serializer for java.util.TreeSet<java.lang.Character>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_936607009 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_936607009();
		
		public BSerializer_936607009() 
			: base(936607009) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<char> arr = new HashSet<char>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				char obj = bbuf.getChar();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			HashSet<char> arr = (HashSet<char>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (char obj in arr) {
				bbuf.putChar(obj);
			}
		}
		
	}
} // namespace
