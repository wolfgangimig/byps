//
// Serializer for byps.test.api.BResult_19
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_534004412 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_534004412();
		
		public BSerializer_534004412()
			: base(534004412) {}
		
		public BSerializer_534004412(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_19 obj = (BResult_19)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_19()));
			
			BBufferBin bbuf = bin.bbuf;
			// void result			
			return obj;
		}
		
	}
} // namespace
