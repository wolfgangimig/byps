//
// Serializer for byps.test.api.cons.ConfigResultOptionC
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.cons
{
	
	public class BSerializer_114832566 : byps.BSerializer_22 {
		
		public readonly static new BSerializer instance = new BSerializer_114832566();
		
		public BSerializer_114832566()
			: base(114832566) {}
		
		public BSerializer_114832566(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			base.write(obj1, bout1, version);			
			ConfigResultOptionC obj = (ConfigResultOptionC)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			ConfigResultOptionC obj = (ConfigResultOptionC)(obj1 != null ? obj1 : bin.onObjectCreated(new ConfigResultOptionC()));
			
			base.read(obj, bin1, version);			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
