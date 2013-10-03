//
// Serializer for com.wilutions.byps.test.api.inherit.BRequest_LemonService_pick
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_1860602130 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1860602130();
		
		public BSerializer_1860602130()
			: base(1860602130) {}
		
		public BSerializer_1860602130(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_LemonService_pick obj = (BRequest_LemonService_pick)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putString(obj._fromTree);
			bout.writeObj(obj._sess, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_LemonService_pick obj = (BRequest_LemonService_pick)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_LemonService_pick()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._fromTree = bbuf.getString();
			obj._sess = (com.wilutions.byps.test.api.auth.SessionInfo)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
