//
// Serializer for java.util.Set<java.lang.Boolean>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1365696060 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_1365696060();
		
		public BSerializer_1365696060() 
			: base(1365696060) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<bool> arr = new HashSet<bool>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				bool obj = bbuf.getBoolean();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			ISet<bool> arr = (ISet<bool>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (bool obj in arr) {
				bbuf.putBoolean(obj);
			}
		}
		
	}
} // namespace
