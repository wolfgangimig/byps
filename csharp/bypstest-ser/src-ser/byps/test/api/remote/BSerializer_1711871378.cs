//
// Serializer for byps.test.api.remote.BRequest_RemoteConstants_compare_HebrewC
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1711871378 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1711871378();
		
		public BSerializer_1711871378()
			: base(1711871378) {}
		
		public BSerializer_1711871378(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteConstants_compare_HebrewC obj = (BRequest_RemoteConstants_compare_HebrewC)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._ALEPH, false, null);
			bout.writeObj(obj._BETH, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteConstants_compare_HebrewC obj = (BRequest_RemoteConstants_compare_HebrewC)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteConstants_compare_HebrewC()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._ALEPH = (byps.test.api.cons.HebrewZ)bin.readObj(false, null);
			obj._BETH = (byps.test.api.cons.HebrewZ)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
