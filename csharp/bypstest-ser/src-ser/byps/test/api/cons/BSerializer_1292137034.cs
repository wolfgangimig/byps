//
// Serializer for byps.test.api.cons.ConfigResultOption
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.cons
{
	
	public class BSerializer_1292137034 : byps.BSerializer_22 {
		
		public readonly static new BSerializer instance = new BSerializer_1292137034();
		
		public BSerializer_1292137034()
			: base(1292137034) {}
		
		public BSerializer_1292137034(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			base.write(obj1, bout1, version);			
			ConfigResultOption obj = (ConfigResultOption)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putInt((int)obj.GroupingType);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putString(obj.String1);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			ConfigResultOption obj = (ConfigResultOption)(obj1 != null ? obj1 : bin.onObjectCreated(new ConfigResultOption()));
			
			base.read(obj, bin1, version);			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.GroupingType = (byps.test.api.cons.GroupingType)bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.String1 = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
