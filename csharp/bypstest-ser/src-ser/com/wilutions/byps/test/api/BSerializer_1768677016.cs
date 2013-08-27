//
// Serializer for java.util.Map<java.lang.String,com.wilutions.byps.test.api.refs.Node>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1768677016 : BSerializer_13 {
		
		public readonly static new BSerializer instance = new BSerializer_1768677016();
		
		public BSerializer_1768677016()
			: base(1768677016) {}		
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			Dictionary<String,com.wilutions.byps.test.api.refs.Node> map = new Dictionary<String,com.wilutions.byps.test.api.refs.Node>();
			bin.onObjectCreated(map);
			int n = bbuf.getLength();
			for (int i = 0; i < n; i++) {
				String key = bbuf.getString();
				com.wilutions.byps.test.api.refs.Node value = (com.wilutions.byps.test.api.refs.Node)bin.readObj(false, null);
				map[key] = value;
			}
			return map;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			Dictionary<String,com.wilutions.byps.test.api.refs.Node> map = (Dictionary<String,com.wilutions.byps.test.api.refs.Node>)obj1;
			int n = map.Count;
			bout.bbuf.putLength(n);
			foreach (KeyValuePair<String,com.wilutions.byps.test.api.refs.Node> obj in map) {
				bbuf.putString(obj.Key);
				bout.writeObj(obj.Value, false, null);
			}
		}
		
	}
} // namespace
