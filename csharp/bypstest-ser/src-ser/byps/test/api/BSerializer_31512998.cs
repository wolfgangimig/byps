//
// Serializer for java.util.HashSet<java.lang.Byte>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_31512998 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_31512998();
		
		public BSerializer_31512998() 
			: base(31512998) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<byte> arr = new HashSet<byte>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				byte obj = bbuf.getByte();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			HashSet<byte> arr = (HashSet<byte>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (byte obj in arr) {
				bbuf.putByte(obj);
			}
		}
		
	}
} // namespace
