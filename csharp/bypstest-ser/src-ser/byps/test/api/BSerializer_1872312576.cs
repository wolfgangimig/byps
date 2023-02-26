//
// Serializer for byps.test.api.BResult_65775978
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1872312576 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1872312576();
		
		public BSerializer_1872312576()
			: base(1872312576) {}
		
		public BSerializer_1872312576(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_65775978 obj = (BResult_65775978)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.resultValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_65775978 obj = (BResult_65775978)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_65775978()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.resultValue = (byps.test.api.auth.SessionInfo)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
