//
// Serializer for byps.test.api.BResult_1361632968
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1548641599 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1548641599();
		
		public BSerializer_1548641599()
			: base(1548641599) {}
		
		public BSerializer_1548641599(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1361632968 obj = (BResult_1361632968)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1361632968.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1361632968 obj = (BResult_1361632968)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1361632968()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.resultValue = (char[])bin.readObj(false, byps.test.api.BSerializer_1361632968.instance);
			
			return obj;
		}
		
	}
} // namespace
