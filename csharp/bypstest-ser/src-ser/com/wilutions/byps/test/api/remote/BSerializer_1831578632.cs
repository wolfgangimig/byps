//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_setImage
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1831578632 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1831578632();
		
		public BSerializer_1831578632()
			: base(1831578632) {}
		
		public BSerializer_1831578632(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: istrm */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteStreams_setImage obj = (BRequest_RemoteStreams_setImage)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._istrm, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_setImage obj = (BRequest_RemoteStreams_setImage)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_setImage()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._istrm = (System.IO.Stream)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
