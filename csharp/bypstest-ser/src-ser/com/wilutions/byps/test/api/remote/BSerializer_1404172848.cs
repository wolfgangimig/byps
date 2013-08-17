//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteReferences_setNode
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1404172848 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1404172848();
		
		public BSerializer_1404172848()
			: base(1404172848) {}
		
		public BSerializer_1404172848(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: v */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteReferences_setNode obj = (BRequest_RemoteReferences_setNode)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteReferences_setNode obj = (BRequest_RemoteReferences_setNode)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteReferences_setNode()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (com.wilutions.byps.test.api.refs.Node)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
