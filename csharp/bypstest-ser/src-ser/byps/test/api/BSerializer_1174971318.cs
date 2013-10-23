//
// Serializer for java.util.List<byte[]>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1174971318 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1174971318();
		
		public BSerializer_1174971318() 
			: base(1174971318) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<byte[]> arr = new List<byte[]>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				byte[] obj = (byte[])bin.readObj(false, byps.test.api.BSerializer_1374008726.instance);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<byte[]> arr = (IList<byte[]>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (byte[] obj in arr) {
				bout.writeObj(obj, false, byps.test.api.BSerializer_1374008726.instance);
			}
		}
		
	}
} // namespace
