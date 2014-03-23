//
// Serializer for task.app.Token
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BSerializer_323961470 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_323961470();
		
		public BSerializer_323961470()
			: base(323961470) {}
		
		public BSerializer_323961470(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Token obj = (Token)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.SessionId);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Token obj = (Token)(obj1 != null ? obj1 : bin.onObjectCreated(new Token()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.SessionId = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
