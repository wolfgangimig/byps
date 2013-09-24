//
// Serializer for com.wilutions.byps.test.api.BResult_1406124761
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_104448059 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_104448059();
		
		public BSerializer_104448059()
			: base(104448059) {}
		
		public BSerializer_104448059(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1406124761 obj = (BResult_1406124761)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_1406124761.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1406124761 obj = (BResult_1406124761)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1406124761()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (ISet<int[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
