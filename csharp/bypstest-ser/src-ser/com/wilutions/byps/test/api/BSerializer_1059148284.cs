//
// Serializer for java.util.List<java.lang.Byte>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1059148284 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1059148284();
		
		public BSerializer_1059148284() 
			: base(1059148284) {}
		
		public override Object read(object obj1, BInput bin1, int version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<byte> arr = new List<byte>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				byte obj = bbuf.getByte();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, int version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<byte> arr = (IList<byte>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (byte obj in arr) {
				bbuf.putByte(obj);
			}
		}
		
	}
} // namespace
