//
// Serializer for byps.test.api.BResult_1633500852
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1231328865 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1231328865();
		
		public BSerializer_1231328865()
			: base(1231328865) {}
		
		public BSerializer_1231328865(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1633500852 obj = (BResult_1633500852)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_1633500852.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1633500852 obj = (BResult_1633500852)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1633500852()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (IList<IDictionary<int,IList<HashSet<int>>>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
