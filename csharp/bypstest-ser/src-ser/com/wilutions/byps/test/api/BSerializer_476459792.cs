//
// Serializer for java.util.TreeMap<java.lang.Integer,java.io.InputStream>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_476459792 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_476459792();
		
		public BSerializer_476459792()
			: base(476459792) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<int,System.IO.Stream> map = new Dictionary<int,System.IO.Stream>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				int key = bbuf.getInt();
				System.IO.Stream value = (System.IO.Stream)bin.readObj(false, null);
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<int,System.IO.Stream> map = (Dictionary<int,System.IO.Stream>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<int,System.IO.Stream> obj in map) {
				bbuf.putInt(obj.Key);
				bout.writeObj(obj.Value, false, null);
			}
		}
		
	}
} // namespace
