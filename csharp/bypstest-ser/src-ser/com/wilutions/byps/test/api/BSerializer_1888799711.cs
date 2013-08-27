//
// Serializer for java.util.Set<java.lang.String>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1888799711 : BSerializer_14 {
		
		public readonly static new BSerializer instance = new BSerializer_1888799711();
		
		public BSerializer_1888799711() 
			: base(1888799711) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			HashSet<String> arr = new HashSet<String>();
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				String obj = bbuf.getString();
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			ISet<String> arr = (ISet<String>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (String obj in arr) {
				bbuf.putString(obj);
			}
		}
		
	}
} // namespace
