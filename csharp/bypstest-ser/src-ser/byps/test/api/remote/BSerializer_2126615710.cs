//
// Serializer for byps.test.api.remote.BRequest_RemoteStreams_setImages
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_2126615710 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2126615710();
		
		public BSerializer_2126615710()
			: base(2126615710) {}
		
		public BSerializer_2126615710(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteStreams_setImages obj = (BRequest_RemoteStreams_setImages)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._doNotReadStreamAtKey);
			bout.writeObj(obj._istrms, false, byps.test.api.BSerializer_779528402.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_setImages obj = (BRequest_RemoteStreams_setImages)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_setImages()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._doNotReadStreamAtKey = bbuf.getInt();
			obj._istrms = (IDictionary<int,System.IO.Stream>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
