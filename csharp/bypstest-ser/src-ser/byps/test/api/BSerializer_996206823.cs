//
// Serializer for byps.test.api.BResult_949340697
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_996206823 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_996206823();
		
		public BSerializer_996206823()
			: base(996206823) {}
		
		public BSerializer_996206823(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_949340697 obj = (BResult_949340697)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_949340697.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_949340697 obj = (BResult_949340697)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_949340697()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (byps.test.api.inl.Point2D[,,,])bin.readObj(false, byps.test.api.BSerializer_949340697.instance);
			
			return obj;
		}
		
	}
} // namespace
