//
// Serializer for java.util.List<task.app.TaskInfo>
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BSerializer_1182472339 : BSerializer_12 {
		
		public readonly static new BSerializer instance = new BSerializer_1182472339();
		
		public BSerializer_1182472339() 
			: base(1182472339) {}
		
		public override Object read(object obj1, BInput bin1, long version) {
			BInputBin bin = ((BInputBin)bin1);
			BBufferBin bbuf = bin.bbuf;
			int n = bbuf.getLength();
			List<task.app.TaskInfo> arr = new List<task.app.TaskInfo>(n);
			bin.onObjectCreated(arr);
			for (int i = 0; i < n; i++) {
				task.app.TaskInfo obj = (task.app.TaskInfo)bin.readObj(false, null);
				arr.Add(obj);
			}
			return arr;
		}
		
		public override void write(Object obj1, BOutput bout1, long version)  {
			BOutputBin bout = ((BOutputBin)bout1);
			BBufferBin bbuf = bout.bbuf;
			IList<task.app.TaskInfo> arr = (IList<task.app.TaskInfo>)obj1;
			int n = arr.Count;
			bout.bbuf.putLength(n);
			foreach (task.app.TaskInfo obj in arr) {
				bout.writeObj(obj, false, null);
			}
		}
		
	}
} // namespace
